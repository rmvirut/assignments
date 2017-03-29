<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class pongMain
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.gameBall = New System.Windows.Forms.PictureBox()
        Me.paddleComputer = New System.Windows.Forms.PictureBox()
        Me.paddlePlayer = New System.Windows.Forms.PictureBox()
        Me.compScoreDraw = New System.Windows.Forms.Label()
        Me.plrScoreDraw = New System.Windows.Forms.Label()
        Me.gameTimer = New System.Windows.Forms.Timer(Me.components)
        CType(Me.gameBall, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.paddleComputer, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.paddlePlayer, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'gameBall
        '
        Me.gameBall.BackColor = System.Drawing.Color.White
        Me.gameBall.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center
        Me.gameBall.Location = New System.Drawing.Point(297, 209)
        Me.gameBall.Name = "gameBall"
        Me.gameBall.Size = New System.Drawing.Size(20, 20)
        Me.gameBall.TabIndex = 0
        Me.gameBall.TabStop = False
        '
        'paddleComputer
        '
        Me.paddleComputer.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(128, Byte), Integer), CType(CType(0, Byte), Integer))
        Me.paddleComputer.Location = New System.Drawing.Point(3, 156)
        Me.paddleComputer.Name = "paddleComputer"
        Me.paddleComputer.Size = New System.Drawing.Size(16, 128)
        Me.paddleComputer.TabIndex = 1
        Me.paddleComputer.TabStop = False
        '
        'paddlePlayer
        '
        Me.paddlePlayer.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(128, Byte), Integer), CType(CType(0, Byte), Integer))
        Me.paddlePlayer.Location = New System.Drawing.Point(605, 156)
        Me.paddlePlayer.Name = "paddlePlayer"
        Me.paddlePlayer.Size = New System.Drawing.Size(16, 128)
        Me.paddlePlayer.TabIndex = 2
        Me.paddlePlayer.TabStop = False
        '
        'compScoreDraw
        '
        Me.compScoreDraw.AutoSize = True
        Me.compScoreDraw.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.compScoreDraw.Font = New System.Drawing.Font("Tahoma", 12.0!, System.Drawing.FontStyle.Bold)
        Me.compScoreDraw.Location = New System.Drawing.Point(266, 9)
        Me.compScoreDraw.Name = "compScoreDraw"
        Me.compScoreDraw.Size = New System.Drawing.Size(19, 19)
        Me.compScoreDraw.TabIndex = 3
        Me.compScoreDraw.Text = "0"
        '
        'plrScoreDraw
        '
        Me.plrScoreDraw.AutoSize = True
        Me.plrScoreDraw.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.plrScoreDraw.Font = New System.Drawing.Font("Tahoma", 12.0!, System.Drawing.FontStyle.Bold)
        Me.plrScoreDraw.Location = New System.Drawing.Point(319, 9)
        Me.plrScoreDraw.Name = "plrScoreDraw"
        Me.plrScoreDraw.Size = New System.Drawing.Size(19, 19)
        Me.plrScoreDraw.TabIndex = 4
        Me.plrScoreDraw.Text = "0"
        '
        'gameTimer
        '
        Me.gameTimer.Enabled = True
        Me.gameTimer.Interval = 20
        '
        'pongMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.AntiqueWhite
        Me.ClientSize = New System.Drawing.Size(624, 441)
        Me.Controls.Add(Me.plrScoreDraw)
        Me.Controls.Add(Me.compScoreDraw)
        Me.Controls.Add(Me.paddlePlayer)
        Me.Controls.Add(Me.paddleComputer)
        Me.Controls.Add(Me.gameBall)
        Me.Name = "pongMain"
        Me.Text = "Pong"
        CType(Me.gameBall, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.paddleComputer, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.paddlePlayer, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents gameBall As PictureBox
    Friend WithEvents paddleComputer As PictureBox
    Friend WithEvents paddlePlayer As PictureBox
    Friend WithEvents compScoreDraw As Label
    Friend WithEvents plrScoreDraw As Label
    Friend WithEvents gameTimer As Timer
End Class
