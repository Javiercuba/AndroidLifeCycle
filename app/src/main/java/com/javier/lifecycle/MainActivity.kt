package com.javier.lifecycle

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        NotifyCycle("onCreate","Recebendo um objeto do tipo “Bundle”")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        Thread.sleep(3000)
        NotifyCycle("onStart","Executado enquanto a atividade está visível para o usuário")
        super.onStart()
    }
    override fun onResume() {
        Thread.sleep(3000)
        NotifyCycle("onResume","Atividade está no topo da pilha de atividades")
        super.onResume()
    }
    override fun onPause() {
        Thread.sleep(3000)
        NotifyCycle("onPause","Prestes a começar a retomar outra atividade.")
        super.onPause()
    }
    override fun onStop() {
        Thread.sleep(2000)
        NotifyCycle("onStop","Atividade está sendo encerrada.")
        super.onStop()
    }
    override fun onDestroy() {
        Thread.sleep(3000)
        NotifyCycle("OnDestroy","Liberar da memória a atividade")
        super.onDestroy()
    }
    override fun onRestart() {
        Thread.sleep(3000)
        super.onRestart()
        NotifyCycle("OnRestart","Atividade parou por algum motivo")
    }


    fun NotifyCycle(method: String,what_do: String){
        lateinit var notificationManager: NotificationManager
        lateinit var builder: Notification.Builder
        val channelId = "com.javier.livecycle"

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                    .setContentTitle("Metodo $method chamado")
                    .setContentText(" $what_do ")

            }
            notificationManager.notify(1234, builder.build())
    }
}