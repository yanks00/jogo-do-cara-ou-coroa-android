package coroa.ou.cara.jogo.jm7087.com.br.jogocaraoucoroa;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class telaRealBr extends AppCompatActivity {

    ImageView moedaView;

    Button btnJogar;

    MediaPlayer som1, som2, somEgg;

    int numeroDeCara, numeroDeCoroa, numeroDeVezesJogadas, numeroAleatrorios, egg;

    TextView numerosAleatoriosView, numeroDeVezesJogadasView, viewNumeroDeCara, viewNumeroDeCoroa;

    WebView moedaGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_real_br);

        moedaView = (ImageView) findViewById(R.id.moedaView);

        moedaGif = (WebView) findViewById(R.id.webMoedaGif);
        moedaGif.loadUrl("file:///android_asset/moedagif.html");

        btnJogar = (Button) findViewById(R.id.btnJogar);

        som1 = MediaPlayer.create(telaRealBr.this,R.raw.somdemoeda);
        som2 = MediaPlayer.create(telaRealBr.this,R.raw.boing);
        somEgg = MediaPlayer.create(telaRealBr.this,R.raw.somegg);

        numerosAleatoriosView = (TextView) findViewById(R.id.viewNumeroAleatrorios);
        numeroDeVezesJogadasView = (TextView) findViewById(R.id.ViewDenumeroDeVezesJogadas);

        viewNumeroDeCara = (TextView) findViewById(R.id.caraView);
        viewNumeroDeCoroa = (TextView) findViewById(R.id.coroaView);

        getSupportActionBar().hide();

    }

    public void Jogar (View view){
        som1.start();

        egg = 0;

        moedaGif.setVisibility(View.GONE);

        numeroDeVezesJogadas = numeroDeVezesJogadas + 1;

        numeroDeVezesJogadasView.setText("NUMEROS DE VEZES JOGADAS: "+ numeroDeVezesJogadas);

        btnJogar.setText("JOGAR DE NOVO");

        numeroAleatrorios = (int)(Math.random()*1000);

        // ver numero aleatrorio
        String mostraNumerosAleatorios;
        mostraNumerosAleatorios = Integer.toString(numeroAleatrorios);
         numerosAleatoriosView.setText(mostraNumerosAleatorios);

        if (numeroAleatrorios %2 == 0){
            numeroDeCara = numeroDeCara + 1;
            viewNumeroDeCara.setText("CARA: "+ numeroDeCara);

            moedaView.setImageResource(R.drawable.cara);

        } else {
            numeroDeCoroa = numeroDeCoroa + 1;
            viewNumeroDeCoroa.setText("COROA: "+ numeroDeCoroa);

            moedaView.setImageResource(R.drawable.coroa);
        }

    }

    public void Zera (View view){
        som2.start();

        numeroDeVezesJogadas = 0;

        numeroDeVezesJogadasView.setText("");

        egg = egg + 1;

        if (egg >= 3){
            somEgg.start();

            numeroDeVezesJogadasView.setText("WWW.JM7087.COM");

        }

        btnJogar.setText("JOGAR");

        numeroDeCara = 0;
        viewNumeroDeCara.setText("CARA: "+ Integer.toString(numeroDeCara));

        numeroDeCoroa = 0;
        viewNumeroDeCoroa.setText("COROA: "+ Integer.toString(numeroDeCoroa));

        moedaView.setImageResource(android.R.color.transparent);

        moedaGif.setVisibility(view.VISIBLE);

    }

}
