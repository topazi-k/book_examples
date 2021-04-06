public class M {
    public static void main(String[] args) {
        M m = new M();
        System.out.println(m.toJadenCase("most trees are blue"));
    }



        public String toJadenCase(String phrase) {
            // TODO put your code below this comment
            if(phrase==null || phrase.isEmpty()) return null;
            StringBuilder sb = new StringBuilder();
            for(String word : phrase.split(" ")){
                sb.append(capitalizeFirstChar(word)+" ");
            }
            return sb.toString().trim();
        }

        private String capitalizeFirstChar(String str){
            char toReplace = str.charAt(0);
            return Character.toUpperCase(toReplace) + str.substring(1, str.length());
        }


}
