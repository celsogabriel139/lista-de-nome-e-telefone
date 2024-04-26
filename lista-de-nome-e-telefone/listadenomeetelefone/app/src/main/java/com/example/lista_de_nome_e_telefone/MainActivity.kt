import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lista_de_nome_e_telefone.R

class MainActivity : AppCompatActivity() {

    private lateinit var listaContatos: ListView
    private lateinit var nomeNovoContato: EditText
    private lateinit var numeroNovoContato: EditText
    private lateinit var botaoAdicionar: Button

    private val contatos = mutableListOf<String>()
    private val adapterContatos: ArrayAdapter<String> by lazy {
        ArrayAdapter(this, android.R.layout.simple_list_item_1, contatos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaContatos = findViewById(R.id.lista_contatos)
        nomeNovoContato = findViewById(R.id.nome_novo_contato)
        numeroNovoContato = findViewById(R.id.numero_novo_contato)
        botaoAdicionar = findViewById(R.id.botao_adicionar)

        listaContatos.adapter = adapterContatos

        botaoAdicionar.setOnClickListener {
            val novoContato = "${nomeNovoContato.text}: ${numeroNovoContato.text}"
            contatos.add(novoContato)
            adapterContatos.notifyDataSetChanged()

            nomeNovoContato.text.clear()
            numeroNovoContato.text.clear()
        }
    }
}
