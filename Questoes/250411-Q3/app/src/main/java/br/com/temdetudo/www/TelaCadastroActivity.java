package br.com.temdetudo.www;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class TelaCadastroActivity extends AppCompatActivity {

    private EditText TextName;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);

        TextName = findViewById(R.id.TextName);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCliente = TextName.getText().toString();

                if (!nomeCliente.isEmpty()) {
                    // criando bundle para enviar o nome
                    Bundle bundle = new Bundle();
                    bundle.putString("NOME_CLIENTE", nomeCliente);

                    Intent intent = new Intent(TelaCadastroActivity.this, telaConfirmacaoActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                } else {
                    TextName.setError("Por favor, digite seu nome");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
