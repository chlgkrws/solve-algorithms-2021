package level2;

public class MakeALargeNumber {

    public String solution(String number, int k){
        String origin = number;
        Integer maxValue = 0;

        for(int i = 0; i < k; i++){
            maxValue = 0;
            String temp = "";
            for(int j = 0; j < origin.length(); j++){
                StringBuilder target= new StringBuilder(origin);

                target.deleteCharAt(j);
                int targetValue = Integer.parseInt(target.toString()+"");
                if(targetValue > maxValue){
                    temp = target.toString();
                }
                maxValue = Integer.max(targetValue, maxValue);
            }
            origin = temp;
        }

        return origin;
    }

    public static void main(String[] args) {
//        MakeALargeNumber a = new MakeALargeNumber();
//        System.out.println(a.solution("87654321", 3));

        System.out.println(Integer.parseInt("001".toString()));
    }
}
