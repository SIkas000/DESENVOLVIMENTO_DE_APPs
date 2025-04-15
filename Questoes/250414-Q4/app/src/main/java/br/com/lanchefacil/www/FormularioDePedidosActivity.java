package br.com.lanchefacil.www;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormularioDePedidosActivity extends AppCompatActivity {

    private EditText InpuText;
    private Button btnLanche1, btnLanche2, btnLanche3, btnLanche4, btnconfirmar;
    private LinearLayout layerLanche1, layerLanche2, layerLanche3, layerLanche4;
    private TextView textLanche1, textLanche2, textLanche3, textLanche4;
    private String nome = "";
    private String LancheNome = "";
    private float precoDoLanche, precoDoLanche1, precoDoLanche2, precoDoLanche3, precoDoLanche4;
    private LinearLayout[] layouts;
    private float[] precos;
    private String[] nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_pedidos);

        InpuText = findViewById(R.id.InpuText);
        btnconfirmar = findViewById(R.id.btnconfirmar);

        textLanche1 = findViewById(R.id.textLanche1);
        textLanche2 = findViewById(R.id.textLanche2);
        textLanche3 = findViewById(R.id.textLanche3);
        textLanche4 = findViewById(R.id.textLanche4);

        btnLanche1 = findViewById(R.id.btnLanche1);
        btnLanche2 = findViewById(R.id.btnLanche2);
        btnLanche3 = findViewById(R.id.btnLanche3);
        btnLanche4 = findViewById(R.id.btnLanche4);

        layerLanche1 = findViewById(R.id.layerLanche1);
        layerLanche2 = findViewById(R.id.layerLanche2);
        layerLanche3 = findViewById(R.id.layerLanche3);
        layerLanche4 = findViewById(R.id.layerLanche4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InicializarArrays();
        ExibirPrecos();
        ConfigurarBotoes();

        btnconfirmar.setOnClickListener(view -> {
            nome = InpuText.getText().toString();

            if (!nome.isEmpty()) {
                Intent intent = new Intent(this, ResumoDoPedidoActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("precoDoLanche", precoDoLanche);
                intent.putExtra("nomeDoLanche", LancheNome);
                startActivity(intent);
                finish();
            } else {
                InpuText.setError("Por favor, digite seu nome");
            }
        });
    }

    private void InicializarArrays() {
        // Inicializa os preços e nomes dos lanches
        precoDoLanche1 = 28.00f;
        precoDoLanche2 = 10.00f;
        precoDoLanche3 = 25.00f;
        precoDoLanche4 = 15.00f;

        precos = new float[]{precoDoLanche1, precoDoLanche2, precoDoLanche3, precoDoLanche4};
        nomes = new String[]{"X-Salada", "Misto Quente", "Cheeseburguer", "Nuggets"};

        layouts = new LinearLayout[]{layerLanche1, layerLanche2, layerLanche3, layerLanche4};
    }

    private void ExibirPrecos() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

        textLanche1.setText("R$" + decimalFormat.format(precoDoLanche1));
        textLanche2.setText("R$" + decimalFormat.format(precoDoLanche2));
        textLanche3.setText("R$" + decimalFormat.format(precoDoLanche3));
        textLanche4.setText("R$" + decimalFormat.format(precoDoLanche4));
    }

    private void ConfigurarBotoes() {
        btnLanche1.setOnClickListener(view -> selecionarLanche(0));
        btnLanche2.setOnClickListener(view -> selecionarLanche(1));
        btnLanche3.setOnClickListener(view -> selecionarLanche(2));
        btnLanche4.setOnClickListener(view -> selecionarLanche(3));
    }

    private void selecionarLanche(int index) {
        CorLayer(index);
        precoDoLanche = precos[index];
        LancheNome = nomes[index];
    }

    private void CorLayer(int index) {
        for (int i = 0; i < layouts.length; i++) {
            if (i == index) {
                layouts[i].setBackgroundColor(Color.rgb(220, 220, 220));
            } else {
                layouts[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
