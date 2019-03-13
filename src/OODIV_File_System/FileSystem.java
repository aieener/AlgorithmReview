package OODIV_File_System;

import java.util.ArrayList;
import java.util.List;

/**
 * FileSystem 提供最核心的ＡＰＩ
 * a in-memory file system
 * 1. files, directories, A dir contains file/sub-dir
 * 2. metadata of files/dir: name, creation time, access time, modification time.
 * 3. A FileSystem can then be modeled as a tree consisting of files/dirs
 *      3.1  LeafNodes: files or empty dir
 *      3.2  Q: how to count the total num of files/dir
 *
 * API 最终是由FileSystem 实现的！
 */

public class FileSystem {
    private Directory root;

    public FileSystem() {
        root = new Directory("/", null);
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);
        if(entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exist: " + path);
        }
        String[] components = path.split("/");
        final String dirName = components[components.length - 1]; // the last elem
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }
    /**
     * resolve a path like /foo/bar
     */
    private List<Entry> resolve(String path) {
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>(components.length + 1);
        entries.add(root);

        Entry entry = root;
        for(String component : components) {
            if(entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("invalid path" + path);
            }

//            if(!component.isEmpty()) {
//                entry = ((Directory) entry).getChild(component);
//                entries.add(entry);
//            }
        }
        return entries;
    }
}
