#include "freeglut.h"
#include "glut.h"


void display() {
	glClear(GL_COLOR_BUFFER_BIT);


	// draw a filled triangle strip
	glBegin(GL_TRIANGLE_STRIP);
		// set the color to be reddish
		
		glColor3f(0.0, 0.7, 0);//green
		
		
		glColor3f(0.7, 0, 0);//red
		// draw the bottom two vertices
		glVertex2f(-0.3, -0.6); //D
		glVertex2f(-0.5, -0.6); //C
		glVertex2f(-0.15, -0.1);//E
		glVertex2f(-0.29, 0.1); //K
		
		glVertex2d(-0.08, 0.1); //I
		glColor3f(0.0, 0.7, 0);//green
		
		glVertex2d(-0.1, 0.7);	//A
		
		glVertex2d(0.0, 0.38);	//L
		glVertex2d(0.1, 0.7);	//B
		glVertex2d(0.09, 0.1);	//J
		glColor3f(0, 0, 0.7);//blue
		glVertex2d(0.28, 0.1);	//M
		glVertex2d(0.2, -0.1);	//O
		glVertex2d(0.5, -0.6);	//G
		
		glVertex2d(0.3, -0.6);	//H
		glVertex2d(0.2, -0.1);	//O
		glColor3f(0.93, 0.93, 0.0);//yellow
		glVertex2d(0.15, -0.1);	//F
		
		glVertex2d(0.09, 0.1);	//J
		glColor3f(0.7, 0, 0);//red
		glVertex2f(-0.15, -0.1);//E
		glVertex2d(-0.08, 0.1);	//I
		glVertex2f(-0.29, 0.1); //K

	glEnd();

	//tl tr br bl
	//correct= tl bl br tr

	glBegin(GL_QUADS);
		glColor3d(1, 1, 1);
		glVertex2d(-0.99, -0.7);//tl
		glVertex2d(0.99, -0.7);//tr
		glVertex2d(0.99, -0.99);//br
		glVertex2d(-0.99, -0.99);//bl
		
	glEnd();
	
	
	glBegin(GL_QUADS);
		glColor3f(0.96,0.87,0.7);
		
		glVertex2d(-0.8, -0.8);//tl
		glVertex2d(-0.4, -0.8);//tr
		glVertex2d(-0.4, -0.95);//br
		glVertex2d(-0.8, -0.95);//bl
	glEnd();

	glBegin(GL_QUADS);
	glColor3f(0.96, 0.87, 0.7);
	glVertex2d(-0.2, -0.8);
	glVertex2d(0.2, -0.8);
	glVertex2d(0.2, -0.95);
	glVertex2d(-0.2, -0.95);
	glEnd();


	glBegin(GL_QUADS);
	glColor3f(0.96, 0.87, 0.7);
	glVertex2d(0.4, -0.8);
	glVertex2d(0.8, -0.8);
	glVertex2d(0.8, -0.95);
	glVertex2d(0.4, -0.95);
	glEnd();

	//button wording
	glColor3f(0.94, 0.66, 0.02);
	glRasterPos2d(-0.74, -0.9);
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 's');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'p');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'a');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'r');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'k');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'l');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'e');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 's');

	glRasterPos2d(-0.1, -0.9);
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 's');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'p');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'a');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'r');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'k');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 's');

	glRasterPos2d(0.51, -0.9);
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'm');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'o');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'r');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'p');
	glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, 'h');
	
	glFlush();
}

void initializeGL() {

	//sets the state variables
	glClearColor(0.0, 0.0, 0.0, 1.0);
	glColor3f(1.0, 1.0, 1.0);

	//sets the viewing variables
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
		
	//sets the attributes
	gluOrtho2D(-1.0, 1.0,-1.0, 1.0);

}


void main(int argc, char** argv) {

	glutInit(&argc, argv);

	//define Window properties
	glutInitDisplayMode(GLUT_RGB | GLUT_STENCIL);
	glutInitWindowPosition(0, 0);
	glutInitWindowSize(500, 500);
	glutCreateWindow("Initials");

	glutDisplayFunc(display);

	initializeGL();
	glutMainLoop();

};