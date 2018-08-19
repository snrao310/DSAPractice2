/*
Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:
Input:
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]

Note:
You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DesignInMemoryFileSystemLeetCode {

    public static class FileSystem {

        private class FileElement{
            String name;
            boolean isFile;
            HashMap<String,FileElement> children;
            String content;
            FileElement(String name, boolean isFile){
                this.name = name;
                this.isFile=isFile;
                if(isFile)
                    content="";
                else
                    children=new HashMap<>();

            }
        }

        FileElement root;

        public FileSystem() {
            root = new FileElement("sysRoot", false);
        }

        public List<String> ls(String path) {
            List<String> result = new ArrayList<>();
            String[] dirs = path.split("/");
            FileElement temp = root;
            for(String dir: dirs){
                if(dir.equals("")) continue;
                if(temp.children!=null && temp.children.containsKey(dir))
                    temp=temp.children.get(dir);
                else
                    return result;
            }
            if(temp.isFile)
                result.add(temp.name);
            else{
                for(String dir: temp.children.keySet())
                    result.add(dir);
            }
            Collections.sort(result);
            return result;
        }

        public void mkdir(String path) {
            List<String> result = new ArrayList<>();
            String[] dirs = path.split("/");
            FileElement temp = root;
            for(String dir: dirs){
                if(dir.equals("")) continue;
                if(!temp.children.containsKey(dir))
                    temp.children.put(dir,new FileElement(dir,false));
                temp=temp.children.get(dir);
            }
        }

        public void addContentToFile(String filePath, String content) {
            List<String> result = new ArrayList<>();
            String[] dirs = filePath.split("/");
            FileElement temp = root;
            for(int i=0;i<dirs.length;i++){
                String dir = dirs[i];
                if(dir.equals("")) continue;
                if(!temp.children.containsKey(dir) && i!=dirs.length-1)
                    temp.children.put(dir,new FileElement(dir, false));
                else if(!temp.children.containsKey(dir) && i==dirs.length-1)
                    temp.children.put(dir,new FileElement(dir, true));
                temp=temp.children.get(dir);
            }
            temp.content+=content;
        }

        public String readContentFromFile(String filePath) {
            List<String> result = new ArrayList<>();
            String[] dirs = filePath.split("/");
            FileElement temp = root;
            for(String dir: dirs){
                if(dir.equals("")) continue;
                temp=temp.children.get(dir);
            }
            return temp.content;
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

    public static void main(String args[]){
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b");
        fs.addContentToFile("/a/b/c","hello");
        System.out.println(fs.readContentFromFile("/a/b/c"));
    }

}
