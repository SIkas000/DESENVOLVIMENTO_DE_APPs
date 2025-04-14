package br.com.temdetudo.www;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaConfirmacaoActivity extends AppCompatActivity {
    private TextView textConfirmacao;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_confirmacao);

        textConfirmacao = findViewById(R.id.textConfirmacao);
        btnVoltar = findViewById(R.id.btnVoltar);

        // pegando o nome do cliente com bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nomeCliente = bundle.getString("NOME_CLIENTE");
            textConfirmacao.setText("Seja Bem-Vindo(a), " + nomeCliente + "!");
        }

        // voltando para a primeira activity com flags e finish
        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(telaConfirmacaoActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
