class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
        while (new_id.indexOf("..") != -1){
            new_id = new_id.replace("..", ".");
        }
        while(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }
        while(new_id.endsWith(".")){
            int leng = new_id.length();
            new_id = new_id.substring(0,leng-1);
        }
        if (new_id.equals(""))
            new_id = "a";
        
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);
        }
        while (new_id.length() < 3)
            new_id += new_id.charAt(new_id.length() - 1);
        return new_id;
    }
}