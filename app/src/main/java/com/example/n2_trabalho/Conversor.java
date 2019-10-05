package com.example.n2_trabalho;

import org.json.JSONException;
import org.json.JSONObject;

public class Conversor {
    public Pessoa getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        Pessoa retorno = parseJson(json);
        return retorno;
    }

    private Pessoa parseJson(String json){
        try {
            Pessoa pessoa = new Pessoa();

            JSONObject jsonObj = new JSONObject(json);
            JSONObject jsonData = new JSONObject(jsonObj.getString("data"));
            pessoa.setName(jsonData.getString("name"));
            pessoa.setColor(jsonData.getString("color"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

}
