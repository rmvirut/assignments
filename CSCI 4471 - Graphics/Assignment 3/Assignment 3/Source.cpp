#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <GL\freeglut.h>
#include <GL\glut.h>
#include <vector>
#include <cmath>

using namespace std;

const float PI = 3.14159265;

const float DEG_TO_RAD = PI / 180.0;

const float GRID_SIZE = 100;

vector<GLfloat> cvectors(3);
vector<GLfloat> cnormals(3);
vector<GLfloat> cfaces(3);

GLfloat theta = 0;

void loadCessna() {
	FILE * cessna = fopen("cessna.txt", "r");

	if (cessna == NULL) {
		printf("Could not open file!");
	}

	while (true)
	{
		char lineHeader[156];

		int res = fscanf(cessna, "%s", lineHeader);
		if (res == EOF)
			break;
	}
}

void loadTextures() {

}

/*
* Draws the cordinate lines in the wireframe
*/
void vectors() {
	//draw white ball
	glColor3f(1, 1, 1);
	glutWireSphere(1, 100, 100);

	//draw x
	glBegin(GL_LINES);
	glLineWidth(5);
	glColor3f(1.0, 0, 0);
	glVertex3f(0.0, 0, 0);
	glVertex3f(10, 0, 0);
	glEnd;

	//draw y
	glBegin(GL_LINES);
	glLineWidth(5);
	glColor3f(1.0, 0, 0);
	glVertex3f(0.0, 0, 0);
	glVertex3f(0, 10, 0);
	glEnd;

	//draw z
	glBegin(GL_LINES);
	glLineWidth(5);
	glColor3f(1.0, 0, 0);
	glVertex3f(0.0, 0, 0);
	glVertex3f(0, 0, 10);
	glEnd;
}

void drawScene() {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	//glDisable(GL_DEPTH_TEST);
	vectors();

	glFlush();
}

void myIdle() {
	
	glutPostRedisplay();
}

void mouseFunction() {

}

void handleKeypress(unsigned char key, int x, int y) {

}

void handleResize(int w, int h) {
	glViewport(0, 0, w, h);

	glMatrixMode(GL_PROJECTION);

	glLoadIdentity();
	gluPerspective(45.0, (double)w / (double)h, 10.0, 100);
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
	glOrtho(-100.0, 100.0, -100.0, 100.0, 10.0, -100.0);
	
}

void main(int argc, char** argv) {
	//initialize
	glutInit(&argc, argv);
	//display mode
	glutInitDisplayMode(GLUT_RGBA | GLUT_DEPTH);
	//window size
	glutInitWindowSize(1000, 800);
	//window position
	glutInitWindowPosition(100, 100);
	//creat window with title
	glutCreateWindow("Solar System");

	//initialize context
	initializeGL();
	//set display function
	glutDisplayFunc(drawScene);
	//idle function
	glutIdleFunc(myIdle);


	//start even loop
	glutMainLoop();
}