Imports System.Text.RegularExpressions

Public Class Form1

    Private exp As String = ""
    Private op1, op2 As Double 'the two operands
    Private operat As Char
    Private flag As Integer = 0
    Dim rgx As New Regex("[+/*-]")

    Private Function clear()
        exp = ""
        flag = 0
        op1 = op2 = 0
    End Function


    Private Function updateScreen()
        TextBox1.Text = exp
    End Function

    Private Sub zero_Click(sender As Object, e As EventArgs) Handles zero.Click

        exp = exp.Insert(exp.Length, "0") 'add 0 to the end of the expression
        updateScreen()

    End Sub

    Private Sub num1_Click(sender As Object, e As EventArgs) Handles num1.Click

        exp = exp.Insert(exp.Length, "1")
        updateScreen()
    End Sub

    Private Sub num2_Click(sender As Object, e As EventArgs) Handles num2.Click
        exp = exp.Insert(exp.Length, "2")
        updateScreen()
    End Sub

    Private Sub num3_Click(sender As Object, e As EventArgs) Handles num3.Click
        exp = exp.Insert(exp.Length, "3")
        updateScreen()
    End Sub

    Private Sub num4_Click(sender As Object, e As EventArgs) Handles num4.Click
        exp = exp.Insert(exp.Length, "4")
        updateScreen()
    End Sub

    Private Sub num5_Click(sender As Object, e As EventArgs) Handles num5.Click
        exp = exp.Insert(exp.Length, "5")
        updateScreen()
    End Sub

    Private Sub num6_Click(sender As Object, e As EventArgs) Handles num6.Click
        exp = exp.Insert(exp.Length, "6")
        updateScreen()
    End Sub

    Private Sub num7_Click(sender As Object, e As EventArgs) Handles num7.Click
        exp = exp.Insert(exp.Length, "7")
        updateScreen()
    End Sub

    Private Sub num8_Click(sender As Object, e As EventArgs) Handles num8.Click
        exp = exp.Insert(exp.Length, "8")
        updateScreen()
    End Sub

    Private Sub num9_Click(sender As Object, e As EventArgs) Handles num9.Click
        exp = exp.Insert(exp.Length, "9")
        updateScreen()
    End Sub

    Private Sub radix_Click(sender As Object, e As EventArgs) Handles radix.Click
        exp = exp.Insert(exp.Length, ".")
        updateScreen()
    End Sub

    Private Sub evaluate_Click(sender As Object, e As EventArgs) Handles evaluate.Click
        Dim validExp As New Regex("[-]?[0-9]*(\.[0-9]+)?[\/*-+][-]?[0-9]*(\.[0-9]+)?")
        If flag > 0 Then
            exp = eval(operat).ToString()
            flag = 0

        End If

    End Sub

    Private Sub sum_Click(sender As Object, e As EventArgs) Handles sum.Click
        addOperator("+")
        updateScreen()
    End Sub

    Private Sub diff_Click(sender As Object, e As EventArgs) Handles diff.Click
        addOperator("-")
        updateScreen()
    End Sub

    Private Sub product_Click(sender As Object, e As EventArgs) Handles product.Click
        addOperator("*")
        updateScreen()
    End Sub

    Private Sub quotient_Click(sender As Object, e As EventArgs) Handles quotient.Click
        addOperator("/")
        updateScreen()
    End Sub

    Private Sub plus_or_minus_Click(sender As Object, e As EventArgs) Handles plus_or_minus.Click
        exp = exp.Insert(exp.Length, "")
        updateScreen()
    End Sub

    Private Sub bckspc_Click(sender As Object, e As EventArgs) Handles bckspc.Click
        If exp.Length = 1 Then 'if it's only one thing then clear the exp
            exp = ""
        ElseIf exp.Length > 1 Then
            If isOperator() Then
                flag = 0
            End If
            exp = exp.Substring(0, exp.Length - 1)
        End If
        updateScreen()
    End Sub

    Private Sub clear_field_Click(sender As Object, e As EventArgs) Handles clear_field.Click
        clear()
        updateScreen()
    End Sub


    Private Function isOperator() As Boolean
        If exp.Length <= 1 Then
            isOperator = rgx.IsMatch(exp)
        Else
            isOperator = rgx.IsMatch(exp(exp.Length - 1))
        End If
    End Function

    Private Function addOperator(op As String)
        'befor adding an operator, check length
        If exp.Length < 1 Then
            'ignore the entry
        ElseIf exp.Length >= 1 And flag < 1 Then 'if the flag is 0 then there's no operator in the expression so simply add
            exp = exp.Insert(exp.Length, op)
            operat = op
            setFlag()
        ElseIf flag > 0 Then 'if there's already a flag
            parseValues() 'parse the values
            exp = eval(operat).ToString() 'evaluate the previous expression before starting a new  and set flag to 0
            exp = exp.Insert(exp.Length, op)
            operat = op
            setFlag()
        End If
    End Function

    Private Function eval(op) As Double

        Select Case op
            Case "/"
                If op2 = 0 Then
                    clear()
                    TextBox1.Text = "Cannot divide by zero. Click CC"
                    eval = 0
                Else
                    eval = op1 / op2
                End If
            Case "+"
                eval = op1 + op2
            Case "-"
                eval = op1 - op2
            Case "*"
                eval = op1 * op2
        End Select
    End Function

    Private Function parseValues()
        op1 = Double.Parse(exp.Substring(0, flag - 1))
        op2 = Double.Parse(exp.Substring(flag))
    End Function

    Private Function setFlag()
        flag = exp.Length
    End Function

End Class