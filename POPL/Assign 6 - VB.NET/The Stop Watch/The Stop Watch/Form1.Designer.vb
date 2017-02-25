<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class stopwatch
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(stopwatch))
        Me.header = New System.Windows.Forms.TextBox()
        Me.clear = New System.Windows.Forms.Button()
        Me.cease = New System.Windows.Forms.Button()
        Me.done = New System.Windows.Forms.Button()
        Me.clock = New System.Windows.Forms.TextBox()
        Me.time = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'header
        '
        resources.ApplyResources(Me.header, "header")
        Me.header.BackColor = System.Drawing.SystemColors.Control
        Me.header.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.header.Cursor = System.Windows.Forms.Cursors.Default
        Me.header.Name = "header"
        '
        'clear
        '
        resources.ApplyResources(Me.clear, "clear")
        Me.clear.Name = "clear"
        Me.clear.UseVisualStyleBackColor = True
        '
        'cease
        '
        resources.ApplyResources(Me.cease, "cease")
        Me.cease.Name = "cease"
        Me.cease.UseVisualStyleBackColor = True
        '
        'done
        '
        resources.ApplyResources(Me.done, "done")
        Me.done.Name = "done"
        Me.done.UseVisualStyleBackColor = True
        '
        'clock
        '
        resources.ApplyResources(Me.clock, "clock")
        Me.clock.Name = "clock"
        '
        'time
        '
        resources.ApplyResources(Me.time, "time")
        Me.time.BackColor = System.Drawing.SystemColors.Control
        Me.time.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.time.Cursor = System.Windows.Forms.Cursors.Default
        Me.time.Name = "time"
        '
        'stopwatch
        '
        resources.ApplyResources(Me, "$this")
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.Controls.Add(Me.time)
        Me.Controls.Add(Me.clock)
        Me.Controls.Add(Me.done)
        Me.Controls.Add(Me.cease)
        Me.Controls.Add(Me.clear)
        Me.Controls.Add(Me.header)
        Me.MaximizeBox = False
        Me.Name = "stopwatch"
        Me.TopMost = True
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents header As TextBox
    Friend WithEvents clear As Button
    Friend WithEvents cease As Button
    Friend WithEvents done As Button
    Friend WithEvents clock As TextBox
    Friend WithEvents time As TextBox
End Class
