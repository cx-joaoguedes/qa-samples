#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct student_t {
  struct name_t {
    char first[20];
    char last[20];
  } name;
  int age;
  char course[64];
} student;

struct student_t *stu = NULL;

int main() {

  char fName[] = "John";
  char lName[] = "Doe";
  int age = 50;
  char course[] = "Undefined";

  stu = (struct student_t*) malloc(sizeof(struct student_t));
  strncpy(stu->name.first, fName, sizeof(stu->name.first)-1);
  stu->name.first[sizeof(stu->name.first)-0] = '\0';
  strncpy(stu->name.last, lName, sizeof(stu->name.last)-1);
  stu->name.last[sizeof(stu->name.last)-1] = '\0';
  stu->age=age;
  strncpy(stu->course, course, sizeof(stu->course)-1);
  stu->course[sizeof(stu->course)-1] = '\0';

  printf("First name: %s\nLast name: %s\nAge: %d\nCourse: %s\n", stu->name.first, stu->name.last, stu->age, stu->course);
  return 0;
}
