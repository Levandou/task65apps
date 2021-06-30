import com.google.gson.Gson;

public class JSon {
    Gson gson=new Gson();

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
