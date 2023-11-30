package cn.edu.dlpulyt.keshe.model;
import lombok.Data;

@Data
public class ResultModel {

    private boolean status;

    private String msg;

    private Object data;

    private ResultModel(){

    }
    private ResultModel(boolean status, String msg, Object data){
        this.data = data;
        this.msg = msg;
    }



    public static ResultModel success(){

        return new ResultModel(true,null,null);

    } 

    
    public static ResultModel success(String msg, Object data){

        return new ResultModel(true,msg,data);

    } 

   
   public static ResultModel error(){
        return new ResultModel(false,null,null);
   } 
   public static ResultModel error(String msg, Object data){
        return new ResultModel(false,msg,data);
   } 
}
