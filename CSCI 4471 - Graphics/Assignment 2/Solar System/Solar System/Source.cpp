#include <stdlib.h>
#include <GL\freeglut.h>
#include <GL\glut.h>
#include <cmath>

float PI = 3.14159265;

float DEG_TO_RAD = PI / 180.0;

GLfloat theta = 0;

//{{sun}, {mercury}, {venus}, {earth}, {moon}, 
//{mars}, {jupiter}, {saturn}, {uranus}, {neptune}, {pluto}}

GLfloat planetColors[][3] = { { 0.99, 0.71, 0.08 }, { 1, 0.63, 0.42 }, { 0.99, 0.84, 0.61 }, { 0.0, 0.41, 0.55 },
{1,1,1}, { 0.55, 0, 0 }, { 0.93, 0.90, 0.87 }, { 0.93, 0.91, 0.75 }, { 0.69, 0.92, 0.92 }, { 0.61, 0.77, 0.89 }, { 0.99, 0.71, 0.08 } };

//planet start points
GLfloat planetPoints[][3] = { {0,0,0}, {0.15, 0, 0}, { 0.10, 0, 0 }, {0.125, 0, 0 }, { 0.135, 0, 0 },
{ 0.175, 0, 0 }, {0.235, 0, 0 }, { 0.315, 0, 0 }, {0.38, 0, 0 }, {0.43, 0, 0 }, {0.49, 0, 0 } };

GLfloat planetSizes[] = { 0.11, 0.015, 0.022, 0.027, 0.015, 0.02, 0.06, 0.050, 0.03, 0.0225 , 0.075 };

GLfloat orbitAngles[] = {0, 4.7, 3.5, 2.9, 2.4, 1.3, 1.0, 0.7, 0.54, 0.47};

GLboolean orbits = true;

void planets() {
	glLoadIdentity();
	//draw sun
	glColor3fv(planetColors[0]);
	//glPushMatrix();
	glutWireSphere(0.1, 100, 100);
	//glPopMatrix();
	//glLoadIdentity();
	for (int i = 1; i < 10; i++) {
		GLfloat x = planetPoints[i][0]; //x co-ordinate
		GLfloat y = planetPoints[i][1]; 
		GLfloat z = planetPoints[i][2]; //z co-ordinate

		GLfloat radius = sqrtf((x*x) + (z*z)); //radius

		x = (float)(radius * cos((theta + orbitAngles[i]) * DEG_TO_RAD));
		z = (float)(radius * sin((theta + orbitAngles[i]) * DEG_TO_RAD));

		glColor3fv(planetColors[i]);
		glLoadIdentity();
		//glPushMatrix();
		glTranslatef(x, y, z);
		glutWireSphere(planetSizes[i], 100, 100);
		//glPopMatrix();
		
	}
	
}

void myIdle() {
	//update rotation
	theta += 1;

	if (theta >= 360.0) {
		theta -= 360;
	}

	glutPostRedisplay();
}

void display() {

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity();
	planets();

	/*
	if (orbits) {
		GLfloat radius = sqrtf((x*x) + (z*z));
		glColor3f(1, 1, 1);
		glBegin(GL_LINE_LOOP);

		for (int theta = 0; theta < 360; ++theta) {
			glVertex3f(radius * cos(theta), 0, radius*sin(theta));
		}
		glEnd;
	}
	*/
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
	glOrtho(-2.0, 2.0, -1.0, 1.0, 5.0, -5.0);
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