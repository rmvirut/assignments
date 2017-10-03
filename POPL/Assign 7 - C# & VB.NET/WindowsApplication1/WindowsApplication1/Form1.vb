Public Class pongMain

#Region "Globals"
    Dim speed As Single = 10 ' Ball Speed
    Dim rndInst As New Random() ' Random instance
    Dim xVel As Single = Math.Cos(rndInst.Next(5, 10)) * speed
    Dim yVel As Single = Math.Sin(rndInst.Next(5, 10)) * speed
#End Region
    ' The player's scores.
    Dim compScore As Integer = 0
    Dim plrScore As Integer = 0


#Region "Hide Cursor"
    ' Set up the game.
    Private Sub pongMain_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Cursor.Hide()
    End Sub
#End Region


#Region "Move the paddle according to the keypress"
    ' Move the paddle according to the mouse position.
    Private Sub pongMain_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles Me.KeyDown
        If e.KeyCode = Keys.Up Then
            paddlePlayer.Location = New Point(paddlePlayer.Location.X, paddlePlayer.Location.Y - 7)
        End If

        If e.KeyCode = Keys.Down Then
            paddlePlayer.Location = New Point(paddlePlayer.Location.X, paddlePlayer.Location.Y + 7)
        End If
    End Sub
#End Region

#Region "Main Timer"
    Private Sub gameTimer_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles gameTimer.Tick
        'create graphic for the gameBall
        Dim g As Graphics = gameBall.CreateGraphics()
        Dim redBrush As New SolidBrush(Color.Red)
        Dim x As Integer = 0
        Dim y As Integer = 0
        Dim w As Integer = gameBall.Width
        Dim h As Integer = gameBall.Height
        g.FillEllipse(redBrush, x, y, w, h)

        'Set the computer player to move according to the ball's position."
        If gameBall.Location.Y > 5 And gameBall.Location.Y < Me.Height - 40 _
        - paddlePlayer.Height Then _
        paddleComputer.Location = New Point(paddleComputer.Location.X, gameBall.Location.Y)

        ' Move the game ball.
        gameBall.Location = New Point(gameBall.Location.X + xVel, gameBall.Location.Y + yVel)

        ' Check for top wall.
        If gameBall.Location.Y < 0 Then
            gameBall.Location = New Point(gameBall.Location.X, 0)
            yVel = -yVel
        End If

        ' Check for bottom wall.
        If gameBall.Location.Y > Me.Height - gameBall.Size.Height - 45 Then
            gameBall.Location = New Point(gameBall.Location.X, Me.Height - gameBall.Size.Height - 45)
            yVel = -yVel
        End If

        ' Check for player paddle.
        If gameBall.Bounds.IntersectsWith(paddlePlayer.Bounds) Then
            gameBall.Location = New Point(paddlePlayer.Location.X - gameBall.Size.Width,
    gameBall.Location.Y)
            xVel = -xVel
        End If

        ' Check for computer paddle.
        If gameBall.Bounds.IntersectsWith(paddleComputer.Bounds) Then
            gameBall.Location = New Point(paddleComputer.Location.X + paddleComputer.Size.Width + 1,
    gameBall.Location.Y)
            xVel = -xVel
        End If

        ' Check for left wall.
        If gameBall.Location.X < 0 Then
            plrScore += 1
            gameBall.Location = New Point(Me.Size.Width / 2, Me.Size.Height / 2)
            plrScoreDraw.Text = Convert.ToString(plrScore)
        End If

        ' Check for right wall.
        If gameBall.Location.X > Me.Width - gameBall.Size.Width - paddlePlayer.Width Then
            compScore += 1
            gameBall.Location = New Point(Me.Size.Width / 2, Me.Size.Height / 2)
            compScoreDraw.Text = Convert.ToString(compScore)
        End If

        If compScore = 15 Or plrScore = 15 Then
            gameTimer.Stop()
            Me.Close()

        End If
    End Sub
#End Region

#Region "End Game on Escape Press"
    ' Escape the game when escape has been pressed.
    Private Sub pongMain_KeyDown(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles Me.KeyDown
        If e.KeyValue = Keys.Escape Then
            Me.Close()
        End If
    End Sub
#End Region

#Region "Keep the paddle and score labels in the correct position when the form is resized."
    Private Sub pongMain_SizeChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.SizeChanged
        paddlePlayer.Location = New Point(Me.Width - 44, paddlePlayer.Location.Y)
        plrScoreDraw.Location = New Point(Me.Width - 54, plrScoreDraw.Location.Y)
    End Sub
#End Region

End Class