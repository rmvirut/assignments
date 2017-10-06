<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
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
        Me.info = New System.Windows.Forms.TextBox()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.helloworld = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'info
        '
        Me.info.BackColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer))
        Me.info.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.info.Cursor = System.Windows.Forms.Cursors.Default
        Me.info.Enabled = False
        Me.info.Font = New System.Drawing.Font("Tw Cen MT Condensed", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.info.Location = New System.Drawing.Point(36, 115)
        Me.info.Name = "info"
        Me.info.ReadOnly = True
        Me.info.Size = New System.Drawing.Size(222, 18)
        Me.info.TabIndex = 0
        Me.info.TabStop = False
        Me.info.Text = "CSCI 3430 - Kojo Acquah - A00384405"
        Me.info.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Button1
        '
        Me.Button1.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer), CType(CType(128, Byte), Integer))
        Me.Button1.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Red
        Me.Button1.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(128, Byte), Integer))
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.Button1.Location = New System.Drawing.Point(96, 58)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(100, 32)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "OK"
        Me.Button1.UseVisualStyleBackColor = False
        '
        'helloworld
        '
        Me.helloworld.AccessibleRole = System.Windows.Forms.AccessibleRole.Text
        Me.helloworld.BackColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer))
        Me.helloworld.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.helloworld.CausesValidation = False
        Me.helloworld.Cursor = System.Windows.Forms.Cursors.Arrow
        Me.helloworld.Font = New System.Drawing.Font("Imprint MT Shadow", 14.25!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.helloworld.ForeColor = System.Drawing.Color.DarkRed
        Me.helloworld.HideSelection = False
        Me.helloworld.ImeMode = System.Windows.Forms.ImeMode.Disable
        Me.helloworld.Location = New System.Drawing.Point(36, 12)
        Me.helloworld.Name = "helloworld"
        Me.helloworld.ReadOnly = True
        Me.helloworld.Size = New System.Drawing.Size(203, 23)
        Me.helloworld.TabIndex = 2
        Me.helloworld.Text = "Hello World"
        Me.helloworld.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer))
        Me.ClientSize = New System.Drawing.Size(284, 145)
        Me.Controls.Add(Me.helloworld)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.info)
        Me.Name = "Form1"
        Me.Text = "Hello World"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents info As TextBox
    Friend WithEvents Button1 As Button
    Friend WithEvents helloworld As TextBox
End Class
