package com.example.prak77777;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ekelas;
    private String Snama, Skelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);

        Enama = (EditText) findViewById(R.id.create_nama);
        Ekelas = (EditText) findViewById(R.id.create_kelas);

        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Skelas = String.valueOf(Ekelas.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi
                            nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Skelas.equals("")) {
                    Ekelas.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi
                            kelas",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Ekelas.setText("");
                    Toast.makeText(MainCreate.this, "Data telah
                            ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Mahasiswa(null, Snama,
                            Skelas));

                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }

            }
        });
    }
}
