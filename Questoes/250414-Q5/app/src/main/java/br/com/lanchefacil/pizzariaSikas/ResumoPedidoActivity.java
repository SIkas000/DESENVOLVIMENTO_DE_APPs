package br.com.lanchefacil.pizzariaSikas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedidoActivity extends AppCompatActivity {

    private TextView T4TextResumo;
    private Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        Log.i("Ciclo de Vida", "Tela 4 - OnCreate");

        T4TextResumo = findViewById(R.id.T4TextResumo);
        btnReset = findViewById(R.id.btnReset);

        //pegando dados
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double valorPizza = bundle.getDouble("valorPizza");
            String metodoPagamento = bundle.getString("metodoPagamento");
            String sabores = bundle.getString("Sabores");

            String resumo = "Sabores: " + sabores + "\n" +
                    "Valor da Pizza: R$" + valorPizza + "\n" +
                    "Método de Pagamento: " + metodoPagamento;

            T4TextResumo.setText(resumo);
        }

        btnReset.setOnClickListener(view -> {
            Intent intent = new Intent(ResumoPedidoActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Fecha a tela atual
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}