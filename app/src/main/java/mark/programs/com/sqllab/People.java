package mark.programs.com.sqllab;

/**
 * Created by root on 10/24/17.
 */

public class People {
    int _id;
    String _name;
    String _gender;

    public People(){
    }
    public People(int id,String name,String gender){
        this._id=id;
        this._name=name;
        this._gender=gender;
    }
    public People(String name,String gender){
        this._name=name;
        this._gender=gender;
    }
    public int getID(){
        return this._id;
    }
    public void setID(int id){
        this._id=id;
    }
    public String getName(){
        return this._name;
    }
    public void setName(String name){this._name=name;}
    public String getGender(){return this._gender;}
    public void setGender(String gender){this._gender=gender;}
}
