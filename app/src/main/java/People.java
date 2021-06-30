public class People {
    private String f_name;
    private String l_name;
    private String birthday;
    private String avatr_url;
    private String specialty_id;
    private String name;

    public People(String f_name,String l_name,String birthday,String avatr_url,String specialty_id,String name){
        this.f_name=f_name;
        this.l_name=l_name;
        this.birthday=birthday;
        this.avatr_url=avatr_url;
        this.specialty_id=specialty_id;
        this.name=name;

    }

    public String getAvatr_url() {
        return avatr_url;
    }

    public String getSpecialty_id() {
        return specialty_id;
    }

    public String getName() {
        return name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getBirthday() {
        return birthday;
    }




    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setAvatr_url(String avatr_url) {
        this.avatr_url = avatr_url;
    }

    public void setSpecialty_id(String specialty_id) {
        this.specialty_id = specialty_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    @Override
    public String toString() {
        return "People{" +
                "f_name='" + f_name + '\n' +
                ", l_name='" + l_name + '\n' +
                ", birthday='" + birthday + '\n' +
                ", avatr_url='" + avatr_url + '\n' +
                ", specialty_id='" + specialty_id + '\n' +
                ", name='" + name + '\n' +
                '}';
    }
}
