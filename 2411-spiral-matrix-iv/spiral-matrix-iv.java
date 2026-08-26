/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res=new int[m][n];
        for(int i[]:res){
            Arrays.fill(i,-1);
        }

        int colStart=0;
        int rowStart=0;

        int colEnd=n-1;
        int rowEnd=m-1;

        ListNode curr=head;

        while(curr!=null){
            // left to right
            for(int i=colStart;i<=colEnd;i++){
                int val=curr==null?-1:curr.val;
                res[rowStart][i]=val;

                curr=curr!=null?curr.next:null;
            }
            rowStart++;
            

            // top to bottom

            for(int i=rowStart;i<=rowEnd;i++){
                int val=curr==null?-1:curr.val;
                res[i][colEnd]=val;

                
                curr=curr!=null?curr.next:null;
            }colEnd--;



            // right  to left

            if(rowStart<=rowEnd){
            for(int i=colEnd;i>=colStart;i--){
                int val=curr==null?-1:curr.val;
                res[rowEnd][i]=val;

                
                curr=curr!=null?curr.next:null;
            }rowEnd--;
            }
            // bottom to top

            if(colStart<=colEnd){
             for(int i=rowEnd;i>=rowStart;i--){
                int val=curr==null?-1:curr.val;
                res[i][colStart]=val;

                
                curr=curr!=null?curr.next:null;
            }colStart++;}

        }

      
        


        return res;
    }
}