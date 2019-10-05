package com.example.n2_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView color;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        name = (TextView)findViewById(R.id.name);
        color = (TextView)findViewById(R.id.color);

        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, Pessoa> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Pessoa doInBackground(Void... arams) {
            Conversor util = new Conversor();
            return util.getInformacao("https://reqres.in/api/user/2");
        }

        @Override
        protected void onPostExecute(Pessoa pessoa){
            name.setText(pessoa.getName());
            color.setText(pessoa.getColor());

            load.dismiss(); //deleta o dialog
        }
    }
}
