public class removeComments{
    public void remove(){
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            if(flag == false && s.indexOf("/*") != -1) {
                flag = true;
                System.out.print(s.substring(0, s.indexOf("/*")));
            }
            if(flag == true && s.indexOf("*/") != -1) {
                flag = false;
                System.out.print(s.substring(s.indexOf("*/") + 2));
            }
            if(flag == true) {
                continue;
            }
            if(flag == false && s.indexOf("*/") == -1) {
                System.out.print(s);
            }
        }
        sc.close();
    }.
}