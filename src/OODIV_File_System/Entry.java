package OODIV_File_System;

/**
 * 互相关联的结构：
 * NaryTree
 * create a new file -> add a new node/subtree
 * delete a file/dir -> remove a node/subtree
 * move a file/dir   -> move a node/subtree
 *
 * Entry will be the base class for file and dir
 */

public abstract class Entry {
    //--------- meta data ------------
    // 描述data --> meta data
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name; // this is the local name!
    //-------------------------------

    public Entry(String n, Directory p) {
        name = n;
        parent = p;
        created = System.currentTimeMillis();
    }

    public boolean delete() {
        if(parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public abstract int size();

    public String getFullPath() {
        if(parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getCreationTime() {
        return created;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public void changeName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}

