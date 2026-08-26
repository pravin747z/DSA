class Solution {

    public boolean compare(int start1,int end1,int start2,int end2,String s){
        int length=end1-start1+1;

        for(int i=0;i<length;i++){
            char ch1=s.charAt(start1+i);
            char ch2=s.charAt(start2+i);

            if(ch1<ch2){
                return true;
            }else if(ch1>ch2){
                return false;
            }

        }

        return false;
    }


    public int updateStart(int start,int sum,String s,int k){
        int pointer=start;
        int length=s.length();

        while(pointer<length && sum>=k){
            int curr=s.charAt(pointer)-'0';
            sum-=curr;
            pointer++;
        }


        return pointer-1;
    }   





    public String shortestBeautifulSubstring(String s, int k) {
        int length=s.length();
        int sum=0;
        
        
        int start=0;

        
        int[] res={-1,-1};

        for(int i=0;i<length;i++){
            int curr=s.charAt(i)-'0';

            sum+=curr;

            if(sum>k){
                start=updateStart(start,sum,s,k);
                sum--;
            }else if(sum==k){
                
                start=updateStart(start,sum,s,k);

            }

            int len=i+1-start;
            int prevLen=res[1]-res[0];


            if(i==5){
                System.out.println("start is : "+start);
                System.out.println("sum is : "+sum);
                System.out.println("len is : "+len);
            }

            if(len==k && sum==k){
                res[0]=start;
                res[1]=i+1;

                break;
            }
            

            if(sum==k){
                if(res[0]==-1){
                    res[0]=start;
                    res[1]=i+1;

                }else if(len<prevLen){
                    res[0]=start;
                    res[1]=i+1;
                }else if(len==prevLen && compare(start,i,res[0],res[1],s)){
                    res[0]=start;
                    res[1]=i+1;

                }

            }

        }


        System.out.println(Arrays.toString(res));

        res[0]=Math.max(res[0],0);
        res[1]=Math.max(res[1],0);
        




        return s.substring(res[0],res[1]);
    }
}