(defun isthere (item1 item2)
	(cond
		((equal nil (car item2)) nil)
		((equal item1 (car item2))
			(equal item1 (car item2)))
		((pop item2)(isthere item1 (cdr item2)))))

(defun superset (list1 list2)
	(cond
		((equal nil (car list2))
			(print list1))
		((member list1 (car list2))
		(print (car list2) 'is 'a 'member)
			(superset list1 (rest list2)))
		((cons list1 (car list2))
			(if (equal nil (car list2))
				(print list1)
				(superset list1 (rest list2))))))
				

Test:

(superset '(a b) '(b c d a))