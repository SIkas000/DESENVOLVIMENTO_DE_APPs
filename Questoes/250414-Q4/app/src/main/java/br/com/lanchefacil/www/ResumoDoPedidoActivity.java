package br.com.lanchefacil.www;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ResumoDoPedidoActivity extends AppCompatActivity {
    private TextView TextLanche, TextTotal, TextNome;
    private Button btnSet;
    private String nome, nomeLanche;
    private float btnconfirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);

        TextLanche = findViewById(R.id.TextLanche);
        TextTotal = findViewById(R.id.TextTotal);
        TextNome = findViewById(R.id.TextNome);
        btnSet = findViewById(R.id.btnSet);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //pegando os dado da tela anterior
        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        nomeLanche = bundle.getString("nomeDoLanche");
        btnconfirmar = bundle.getFloat("precoDoLanche");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);
        TextLanche.setText("Lanche: " + nomeLanche);
        TextTotal.setText("R$" + decimalFormat.format(btnconfirmar));
        TextNome.setText("Ótima escolha " + nome + ", seu pedido já está a caminho, já já você poderá saborear nossos deliciosos laches!!");

        btnSet.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}