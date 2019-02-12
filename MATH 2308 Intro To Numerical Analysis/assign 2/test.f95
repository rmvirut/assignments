program LASimpleDriver
! Setup and solve a linear system, Ax=b, where A is n x n
! Use LAPACK routine SGETRF to factor A = PLU;
! Use LAPACK routine SGETRS to solve Ax=b, using the factored form of A;
! Use LAPACK routine SGECON to obtain an estimate of Cond(A); use SLANGE to compute norm of A

      implicit none ! Require all variables to be declared

!     Declaration (and initialization) of variables for SGETRF
	integer, parameter :: n = 3   ! m=n so no need to declare m
      integer, parameter :: lda = 3

	real :: A(lda,n)
	integer :: ipiv(n), info

!     Declaration (and initialization) of additional variables for SGETRF
      character*1, parameter :: trans = 'N'
      integer, parameter  :: nrhs = 1
      integer, parameter :: ldb = n
      real :: b(ldb,nrhs)

!     Declaration (and initialization) of additional variables for SGECON
      character*1, parameter :: norm = 'I'
      real :: anorm, rcond
      real :: work(4*n)
      integer :: iwork(n)
      
!     Declare the norm function, SLANGE, to be real and external, i.e., not
!     defined within the current program
      real slange
      external slange
!--------------------------------------------------------------------------
!     Setup A and b
!     Zero out the entire array A and vector b.
      A = 0.0
      b = 0.0

!     Assign individual non-zero elements of A and b
        A(1,1) =   0.0
        A(1,2) = - 1.0
        A(1,3) =   1.0
        b(1,1) =   4.0

        A(2,1) =   1.0
        A(2,2) = - 1.0
        A(2,3) =   0.0
        b(2,1) =   8.0

        A(3,1) = - 1.0
        A(3,2) =   2.0
        A(3,3) = - 1.0
        b(3,1) = - 6.0

!     First compute the norm of A before it is factored
      anorm = slange(norm, n, n, A, lda, work)
      write(*,*) 'anorm = ', anorm

!     Factor the A matrix; the factors L,U are returned in A; P info returned in ipiv
      call sgetrf(n, n, A, lda, ipiv, info)
      write(*,*) 'SGETRF: info = ', info
      if (info .NE. 0) stop

!     A has now become LU and P remains ipiv
!     Now solve PLUy = c => Ay = c  => Ax = b
!     Solve Ax=b; the solution x is returned in b
      call sgetrs(trans, n, nrhs, A, lda, ipiv, b, ldb, info)
      write(*,*) 'SGETRS: info = ', info
      if (info .NE. 0) stop

      print *, ' the program runs'

!     Print results
	write(*,*) ' Solution =', b

      b = 0.0

      b(1,1) =   4
      b(2,1) =   8
      b(3,1) = - 6

!     Solve Ax=b; the solution x is returned in b
      call sgetrs(trans, n, nrhs, A, lda, ipiv, b, ldb, info)
      write(*,*) 'SGETRS: info = ', info
      if (info .NE. 0) stop

!     Print results
	write(*,*) ' Solution =', b

end program LASimpleDriver
