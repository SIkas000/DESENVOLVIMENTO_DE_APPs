package br.com.lanchefacil.pizzariaSikas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class SelecaoDePizzaActivity extends AppCompatActivity {

    private CheckBox cbSabor1, cbSabor2, cbSabor3, cbSabor4, cbSabor5, cbSabor6, cbSabor7, cbSabor8;
    private Button btnAddCarrinho;
    private int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_de_pizza);

        cbSabor1 = findViewById(R.id.cbSabor1);
        cbSabor2 = findViewById(R.id.cbSabor2);
        cbSabor3 = findViewById(R.id.cbSabor3);
        cbSabor4 = findViewById(R.id.cbSabor4);
        cbSabor5 = findViewById(R.id.cbSabor5);
        cbSabor6 = findViewById(R.id.cbSabor6);
        cbSabor7 = findViewById(R.id.cbSabor7);
        cbSabor8 = findViewById(R.id.cbSabor8);

        btnAddCarrinho = findViewById(R.id.btnAddCarrinho);

        Intent recebendo = getIntent();
        quantidade = recebendo.getIntExtra("Quantidade", 1);

        btnAddCarrinho.setOnClickListener(view -> {
            String saboresSelecionados = SaboresSelecionados();
            int quantidadePizzas = contarPizzasSelecionadas();

            if (quantidadePizzas == 0) {
                Toast.makeText(this, "Selecione pelo um sabor de pizza, por favor", Toast.LENGTH_SHORT).show();
                return; //garante que o usuario selecione pelo menos uma pizza
            }

            //enviando as informações
            Intent intent = new Intent(this, SelecaoTamanhoPagamentoActivity.class);
            intent.putExtra("Sabores", saboresSelecionados);
            intent.putExtra("Quantidade", quantidadePizzas);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String SaboresSelecionados() {
        String sabores = "";
        if (cbSabor1.isChecked()) {
            sabores = cbSabor1.getText().toString() + ("\n");
        }
        if (cbSabor2.isChecked()) {
            sabores += cbSabor2.getText().toString() + ("\n");
        }
        if (cbSabor3.isChecked()) {
            sabores += cbSabor3.getText().toString() + ("\n");
        }
        if (cbSabor4.isChecked()) {
            sabores += cbSabor4.getText().toString() + ("\n");
        }
        if (cbSabor5.isChecked()) {
            sabores += cbSabor5.getText().toString() + ("\n");
        }
        if (cbSabor6.isChecked()) {
            sabores += cbSabor6.getText().toString() + ("\n");
        }
        if (cbSabor7.isChecked()) {
            sabores += cbSabor7.getText().toString() + ("\n");
        }
        if (cbSabor8.isChecked()) {
            sabores += cbSabor8.getText().toString() + ("\n");
        }

        return sabores.toString();
    }

    private int contarPizzasSelecionadas() {
        int quantidade = 0;
        if (cbSabor1.isChecked()) quantidade++;
        if (cbSabor2.isChecked()) quantidade++;
        if (cbSabor3.isChecked()) quantidade++;
        if (cbSabor4.isChecked()) quantidade++;
        if (cbSabor5.isChecked()) quantidade++;
        if (cbSabor6.isChecked()) quantidade++;
        if (cbSabor7.isChecked()) quantidade++;
        if (cbSabor8.isChecked()) quantidade++;
        return quantidade;
    }
}