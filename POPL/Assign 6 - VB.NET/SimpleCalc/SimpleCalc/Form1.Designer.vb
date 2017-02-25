<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
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
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Me.TextBox1 = New System.Windows.Forms.TextBox()
        Me.num1 = New System.Windows.Forms.Button()
        Me.num2 = New System.Windows.Forms.Button()
        Me.num3 = New System.Windows.Forms.Button()
        Me.num4 = New System.Windows.Forms.Button()
        Me.num5 = New System.Windows.Forms.Button()
        Me.num6 = New System.Windows.Forms.Button()
        Me.num7 = New System.Windows.Forms.Button()
        Me.num8 = New System.Windows.Forms.Button()
        Me.num9 = New System.Windows.Forms.Button()
        Me.zero = New System.Windows.Forms.Button()
        Me.radix = New System.Windows.Forms.Button()
        Me.evaluate = New System.Windows.Forms.Button()
        Me.sum = New System.Windows.Forms.Button()
        Me.diff = New System.Windows.Forms.Button()
        Me.product = New System.Windows.Forms.Button()
        Me.clear_field = New System.Windows.Forms.Button()
        Me.bckspc = New System.Windows.Forms.Button()
        Me.plus_or_minus = New System.Windows.Forms.Button()
        Me.quotient = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'TextBox1
        '
        Me.TextBox1.Cursor = System.Windows.Forms.Cursors.Default
        Me.TextBox1.Font = New System.Drawing.Font("Candara", 12.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TextBox1.Location = New System.Drawing.Point(8, 12)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(240, 28)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num1
        '
        Me.num1.Location = New System.Drawing.Point(8, 144)
        Me.num1.Name = "num1"
        Me.num1.Size = New System.Drawing.Size(56, 23)
        Me.num1.TabIndex = 1
        Me.num1.Text = "1"
        Me.num1.UseVisualStyleBackColor = True
        '
        'num2
        '
        Me.num2.Location = New System.Drawing.Point(70, 144)
        Me.num2.Name = "num2"
        Me.num2.Size = New System.Drawing.Size(56, 23)
        Me.num2.TabIndex = 2
        Me.num2.Text = "2"
        Me.num2.UseVisualStyleBackColor = True
        '
        'num3
        '
        Me.num3.Location = New System.Drawing.Point(132, 144)
        Me.num3.Name = "num3"
        Me.num3.Size = New System.Drawing.Size(56, 23)
        Me.num3.TabIndex = 3
        Me.num3.Text = "3"
        Me.num3.UseVisualStyleBackColor = True
        '
        'num4
        '
        Me.num4.Location = New System.Drawing.Point(8, 115)
        Me.num4.Name = "num4"
        Me.num4.Size = New System.Drawing.Size(56, 23)
        Me.num4.TabIndex = 4
        Me.num4.Text = "4"
        Me.num4.UseVisualStyleBackColor = True
        '
        'num5
        '
        Me.num5.Location = New System.Drawing.Point(70, 115)
        Me.num5.Name = "num5"
        Me.num5.Size = New System.Drawing.Size(56, 23)
        Me.num5.TabIndex = 5
        Me.num5.Text = "5"
        Me.num5.UseVisualStyleBackColor = True
        '
        'num6
        '
        Me.num6.Location = New System.Drawing.Point(132, 115)
        Me.num6.Name = "num6"
        Me.num6.Size = New System.Drawing.Size(56, 23)
        Me.num6.TabIndex = 6
        Me.num6.Text = "6"
        Me.num6.UseVisualStyleBackColor = True
        '
        'num7
        '
        Me.num7.Location = New System.Drawing.Point(8, 86)
        Me.num7.Name = "num7"
        Me.num7.Size = New System.Drawing.Size(56, 23)
        Me.num7.TabIndex = 7
        Me.num7.Text = "7"
        Me.num7.UseVisualStyleBackColor = True
        '
        'num8
        '
        Me.num8.Location = New System.Drawing.Point(70, 86)
        Me.num8.Name = "num8"
        Me.num8.Size = New System.Drawing.Size(56, 23)
        Me.num8.TabIndex = 8
        Me.num8.Text = "8"
        Me.num8.UseVisualStyleBackColor = True
        '
        'num9
        '
        Me.num9.Location = New System.Drawing.Point(132, 86)
        Me.num9.Name = "num9"
        Me.num9.Size = New System.Drawing.Size(56, 23)
        Me.num9.TabIndex = 9
        Me.num9.Text = "9"
        Me.num9.UseVisualStyleBackColor = True
        '
        'zero
        '
        Me.zero.Location = New System.Drawing.Point(8, 173)
        Me.zero.Name = "zero"
        Me.zero.Size = New System.Drawing.Size(56, 23)
        Me.zero.TabIndex = 10
        Me.zero.Text = "0"
        Me.zero.UseVisualStyleBackColor = True
        '
        'radix
        '
        Me.radix.Location = New System.Drawing.Point(70, 173)
        Me.radix.Name = "radix"
        Me.radix.Size = New System.Drawing.Size(56, 23)
        Me.radix.TabIndex = 11
        Me.radix.Text = "."
        Me.radix.UseVisualStyleBackColor = True
        '
        'evaluate
        '
        Me.evaluate.Location = New System.Drawing.Point(132, 173)
        Me.evaluate.Name = "evaluate"
        Me.evaluate.Size = New System.Drawing.Size(118, 23)
        Me.evaluate.TabIndex = 12
        Me.evaluate.Text = "="
        Me.evaluate.UseVisualStyleBackColor = True
        '
        'sum
        '
        Me.sum.Location = New System.Drawing.Point(194, 144)
        Me.sum.Name = "sum"
        Me.sum.Size = New System.Drawing.Size(56, 23)
        Me.sum.TabIndex = 13
        Me.sum.Text = "+"
        Me.sum.UseVisualStyleBackColor = True
        '
        'diff
        '
        Me.diff.Location = New System.Drawing.Point(194, 115)
        Me.diff.Name = "diff"
        Me.diff.Size = New System.Drawing.Size(56, 23)
        Me.diff.TabIndex = 14
        Me.diff.Text = "-"
        Me.diff.UseVisualStyleBackColor = True
        '
        'product
        '
        Me.product.Location = New System.Drawing.Point(194, 86)
        Me.product.Name = "product"
        Me.product.Size = New System.Drawing.Size(56, 23)
        Me.product.TabIndex = 15
        Me.product.Text = "*"
        Me.product.UseVisualStyleBackColor = True
        '
        'clear_field
        '
        Me.clear_field.Location = New System.Drawing.Point(8, 57)
        Me.clear_field.Name = "clear_field"
        Me.clear_field.Size = New System.Drawing.Size(56, 23)
        Me.clear_field.TabIndex = 16
        Me.clear_field.Text = "CC"
        Me.clear_field.UseVisualStyleBackColor = True
        '
        'bckspc
        '
        Me.bckspc.Location = New System.Drawing.Point(69, 57)
        Me.bckspc.Name = "bckspc"
        Me.bckspc.Size = New System.Drawing.Size(57, 23)
        Me.bckspc.TabIndex = 17
        Me.bckspc.Text = "<<"
        Me.bckspc.UseVisualStyleBackColor = True
        '
        'plus_or_minus
        '
        Me.plus_or_minus.Location = New System.Drawing.Point(132, 57)
        Me.plus_or_minus.Name = "plus_or_minus"
        Me.plus_or_minus.Size = New System.Drawing.Size(56, 23)
        Me.plus_or_minus.TabIndex = 18
        Me.plus_or_minus.Text = "±"
        Me.plus_or_minus.UseVisualStyleBackColor = True
        '
        'quotient
        '
        Me.quotient.Location = New System.Drawing.Point(194, 57)
        Me.quotient.Name = "quotient"
        Me.quotient.Size = New System.Drawing.Size(56, 23)
        Me.quotient.TabIndex = 19
        Me.quotient.Text = "/"
        Me.quotient.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(263, 203)
        Me.Controls.Add(Me.quotient)
        Me.Controls.Add(Me.plus_or_minus)
        Me.Controls.Add(Me.bckspc)
        Me.Controls.Add(Me.clear_field)
        Me.Controls.Add(Me.product)
        Me.Controls.Add(Me.diff)
        Me.Controls.Add(Me.sum)
        Me.Controls.Add(Me.evaluate)
        Me.Controls.Add(Me.radix)
        Me.Controls.Add(Me.zero)
        Me.Controls.Add(Me.num9)
        Me.Controls.Add(Me.num8)
        Me.Controls.Add(Me.num7)
        Me.Controls.Add(Me.num6)
        Me.Controls.Add(Me.num5)
        Me.Controls.Add(Me.num4)
        Me.Controls.Add(Me.num3)
        Me.Controls.Add(Me.num2)
        Me.Controls.Add(Me.num1)
        Me.Controls.Add(Me.TextBox1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.Name = "Form1"
        Me.Text = "Simple Calculator"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents TextBox1 As TextBox
    Friend WithEvents num1 As Button
    Friend WithEvents num2 As Button
    Friend WithEvents num3 As Button
    Friend WithEvents num4 As Button
    Friend WithEvents num5 As Button
    Friend WithEvents num6 As Button
    Friend WithEvents num7 As Button
    Friend WithEvents num8 As Button
    Friend WithEvents num9 As Button
    Friend WithEvents zero As Button
    Friend WithEvents radix As Button
    Friend WithEvents evaluate As Button
    Friend WithEvents sum As Button
    Friend WithEvents diff As Button
    Friend WithEvents product As Button
    Friend WithEvents clear_field As Button
    Friend WithEvents bckspc As Button
    Friend WithEvents plus_or_minus As Button
    Friend WithEvents quotient As Button
End Class
