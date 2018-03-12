#include <stdlib.h>
#include <GL\freeglut.h>
#include <GL\glut.h>



void planets() {
	
	//Draw the Sun
	glColor3f(0.99, 0.71, 0.08);
	GLUquadric *sun;
	sun = gluNewQuadric();
	glTranslatef(0, 0, 0);
	gluSphere(sun, 0.11, 100, 100);

	//mercury
	glColor3f(0.98, 0.63, 0.42);
	GLUquadric *hg;
	hg = gluNewQuadric();
	glTranslatef(0.16/2, 0, 0);
	gluSphere(hg, 0.015, 100, 100);

	//venus
	glColor3f(0.99, 0.84, 0.61);
	GLUquadric *venus;
	venus = gluNewQuadric();
	glTranslatef(0.20/2, 0, 0);
	gluSphere(venus, 0.022, 100, 100);

	//earth
	glColor3f(0.0, 0.41, 0.55);
	GLUquadric *earth;
	earth = gluNewQuadric();
	glTranslatef(0.25/2, 0, 0);
	gluSphere(earth, 0.027, 100, 100);

	//Earth's moon
	glColor3f(0.0, 0.41, 0.55);
	GLUquadric *moon;
	moon = gluNewQuadric();
	glTranslatef(0.27 / 2, 0, 0);
	gluSphere(moon, 0.01, 100, 100);

	//mars
	glColor3f(0.55, 0, 0);
	GLUquadric *mars;
	mars = gluNewQuadric();
	glTranslatef(0.35/2, 0, 0);
	gluSphere(mars, 0.015, 100, 100);

	//jupiter
	glColor3f(0.93, 0.90, 0.87);
	GLUquadric *jupiter;
	jupiter = gluNewQuadric();
	glTranslatef(0.47/2, 0, 0);
	gluSphere(jupiter, 0.06, 100, 100);
	
	//saturn
	glColor3f(0.93, 0.91, 0.75);
	GLUquadric *saturn;
	saturn = gluNewQuadric();
	glTranslatef(0.63/2, 0, 0);
	gluSphere(saturn, 0.05, 100, 100);
	
	//uranus
	glColor3f(0.69, 0.92, 0.92);
	GLUquadric *uranus;
	uranus = gluNewQuadric();
	glTranslatef(0.76/2, 0, 0);
	gluSphere(uranus, 0.03, 100, 100);
	
	//neptune
	glColor3f(0.61, 0.77, 0.89);
	GLUquadric *neptune;
	neptune = gluNewQuadric();
	glTranslatef(0.86/2, 0, 0);
	gluSphere(neptune, 0.0225, 100, 100);
	
	//pluto
	glColor3f(0.99, 0.71, 0.08);
	GLUquadric *pluto;
	pluto = gluNewQuadric();
	glTranslatef(0.98/2, 0, 0);
	gluSphere(pluto, 0.075, 100, 100);
}

void myIdle() {
	//does nothing now
}

void display() {

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity();
	planets();

	glFlush();
}

void initializeGL(void) {
	// enable depth test
	glEnable(GL_DEPTH_TEST);
	// set background color
	glClearColor(0.0, 0.0, 0.0, 1.0);
	// set matrix mode
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	// use 3d
	glOrtho(-2.0, 2.0, -1.0, 1.0, 1.0, -1.0);
	// now change matrix mode to allow re-positioning
	glMatrixMode(GL_MODELVIEW);
}


void main(int argc, char** argv) {

	//initialize
	glutInit(&argc, argv);
	//display mode
	glutInitDisplayMode(GLUT_RGBA | GLUT_DEPTH);
	//window size
	glutInitWindowSize(1000, 500);
	//window position
	glutInitWindowPosition(0, 0);
	//creat window with title
	glutCreateWindow("Solar System");

	//initialize context
	initializeGL();
	//set display function
	glutDisplayFunc(display);
	//idle function
	glutIdleFunc(myIdle);
	//start even loop
	glutMainLoop();

}

