package kr.hs.emirim.s2019s05.mirimtoasdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textName,textEmail;//activit.xml;
    EditText editName,editEmail;//dialog.xml
    TextView textToast;
    View dialogView, toastView;
    Button btnHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.text_name);
        textEmail = findViewById(R.id.text_email);

        btnHere = findViewById(R.id.btn_here);
        btnHere.setOnClickListener(btnHereListener);
    }
    View.OnClickListener btnHereListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity.this, R.layout.toast_dialog,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.ic_launcher_foreground);
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인",positiveButtonListener);
            dlg.setNegativeButton("취소",negativeButtonListener);
            dlg.show();
        }
    };

    DialogInterface.OnClickListener positiveButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            editName = dialogView.findViewById(R.id.edit_name);
            editEmail = dialogView.findViewById(R.id.edit_email);

            textName.setText(editName.getText().toString());
            textEmail.setText(editEmail.getText().toString());
        }
    };

    DialogInterface.OnClickListener negativeButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast toast = new Toast(MainActivity.this);
            toastView = View.inflate(MainActivity.this, R.layout.dialog,null);
            textToast = toastView.findViewById(R.id.text_toast);
            textToast.setText("취소 버튼을 누르셨네요 ");
            toast.setView(toastView);
            toast.show();

        }
    };
}