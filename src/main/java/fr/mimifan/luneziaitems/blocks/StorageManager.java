package fr.mimifan.luneziaitems.blocks;

import fr.mimifan.luneziaitems.Main;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class StorageManager {

    private static StorageManager instance = new StorageManager();

    public JSONObject getJSON(File file) throws IOException, ParseException {
        if (!file.exists()) {
            this.createFile(file);
        }

        StringBuilder filetext = new StringBuilder();
        BufferedReader reader;

        try (FileReader fileReader = new FileReader(file)) {
            reader = new BufferedReader(fileReader);
            //Read the file
            String line = reader.readLine();
            while (line != null) {
                filetext.append(line);
                line = reader.readLine();
            }   //Decode the file
            filetext = new StringBuilder(new String(Base64.getDecoder().decode(filetext.toString())));
            //Get as json
            JSONObject json = (JSONObject) new JSONParser().parse(filetext.toString());
            reader.close();
            return json;
        }

    }

    @SuppressWarnings("unchecked")
    public void register(Block block, String tag) {
        Chunk chunk = block.getChunk();
        String filename = chunk.getX() + "." + chunk.getZ() + ".data";
        File file = new File(Main.getInstance().getDataFolder(),  tag + "/" + filename);

        JSONObject json;
        try {
            json = this.getJSON(file);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> data = (ArrayList<String>) json.get("data");
        data.add(block.getX() + "." + block.getY() + "." + block.getZ());
        json.put("data", data);

        try {
            this.save(file, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void unregister(Block block, String tag) {
        Chunk chunk = block.getChunk();
        String filename = chunk.getX() + "." + chunk.getZ() + ".data";
        File file = new File(Main.getInstance().getDataFolder(),  tag + "/" + filename);

        JSONObject json;
        try {
            json = this.getJSON(file);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> data = (ArrayList<String>) json.get("data");
        data.remove(block.getX() + "." + block.getY() + "." + block.getZ());
        json.put("data", data);

        try {
            this.save(file, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean has(Block block, String tag) {
        Chunk chunk = block.getChunk();
        String filename = chunk.getX() + "." + chunk.getZ() + ".data";
        File file = new File(Main.getInstance().getDataFolder(),  tag + "/" + filename);

        JSONObject json;
        try {
            json = this.getJSON(file);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> data = (ArrayList<String>) json.get("data");
        return data.contains(block.getX() + "." + block.getY() + "." + block.getZ());
    }


    @SuppressWarnings("unchecked")
    private void createFile(File file) throws IOException {
        file.mkdirs();
        JSONObject json = new JSONObject();
        json.put("data", new ArrayList<>());
        this.save(file, json);
    }

    private void save(File file, JSONObject json) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(Base64.getEncoder().encodeToString(json.toJSONString().getBytes()));
        }
    }

    public static StorageManager getInstance() {
        return instance;
    }
}
