public class Field {
    private char type;
    Field up;
    Field down;
    Field left;
    Field right;
    boolean visitedFence=false;
    boolean visitedField=false;
    Field(char type){
        this.type = type;
    }
    public char getType(){
        return type;
    }
    public int countFences(){
        int count=0;
        visitedFence=true;
        if(up==null)
            count++;
        else if(!up.visitedFence)
            count+=up.countFences();
        if(down==null)
            count++;
        else if(!down.visitedFence)
            count+=down.countFences();
        if(left==null)
            count++;
        else if(!left.visitedFence)
            count+=left.countFences();
        if(right==null)
            count++;
        else if(!right.visitedFence)
            count+=right.countFences();
        return count;
    }
    public int countFields(){
        int count=0;
        visitedField=true;
        if(up!=null){
            if(!up.visitedField) {
                count+=up.countFields();
            }
        }
        if(down!=null){
            if(!down.visitedField) {
                count+=down.countFields();
            }
        }
        if(left!=null){
            if(!left.visitedField) {
                count+=left.countFields();
            }
        }
        if(right!=null){
            if(!right.visitedField) {
                count+=right.countFields();
            }
        }
        return count+1;
    }
    public String toString(){
        return type+" ";
    }
}
