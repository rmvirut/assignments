
Public Class Form1

    Dim StopWatch As New Diagnostics.Stopwatch
    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        Dim elapsed As TimeSpan = Me.StopWatch.Elapsed
        Label1.Text = String.Format("{0:00}.{1:00}", elapsed.Seconds, (elapsed.Milliseconds / 10))
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If Button1.Text = "Start" Then
            Button1.Text = "Stop"
            Timer1.Start()
            Me.StopWatch.Start()
            Label1.ForeColor = Color.Green
        Else
            Button1.Text = "Start"
            Timer1.Stop()
            Me.StopWatch.Stop()
            Label1.ForeColor = Color.Red
        End If
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Me.StopWatch.Reset()
        Label1.Text = "00:00:00:000"
    End Sub

    Private Sub Button3_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Timer1.Stop()
        Me.Close()
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub
End Class

