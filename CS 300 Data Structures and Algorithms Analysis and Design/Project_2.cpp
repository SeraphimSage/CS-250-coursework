//============================================================================
// Name        : Project_2.cpp
// Author      : Kenneth Pinkerton
// Version     : 1.0
// Description : Project 2
//============================================================================

#include <iostream>
#include <fstream>
#include <string>
#include <time.h>
#include <Windows.h>
#include <vector>

using namespace std;

// Object creation structure with reusable variables
struct Course {
    string courseId;
    string courseName;
    vector<string> preList;
};

// Binary Search Tree decided on for simplifying structure 
// and maintaining quick runtime.
class BinarySearchTree {

    // Private data variables to keep objects abstracted to an apppropriate degree.
    private:

        // Define course nodes that will hold all information
        struct Node {
            Course course;
            Node* right;
            Node* left;

            // Default constructor node
            Node() {
                left = nullptr;
                right = nullptr;
            }

            // Initialize empty node item
            Node(Course iCourse) {
                course = iCourse;
                left = nullptr;
                right = nullptr;
            }
    };

        // Assign root location and tree size, 
        // provide information for sorting tree
        Node* root;
        void inOrder(Node* node);
        int size = 0;

    // Public data variables keeping to best practice of abstraction 
    // and allowing other items to appropriately read information 
    // that should be read outside of functions and defining
    // what functions will be attached to the BST data objects
    public:
        BinarySearchTree();
        void InOrder();
        void Insert(Course iCourse);
        Course Search(string courseId);
        int Size();
};

// Default constructor
BinarySearchTree::BinarySearchTree() {
    this->root = nullptr;
}

// Define how tree is traversed and where it begins
void BinarySearchTree::InOrder() {
    inOrder(root);
}

// Function to insert course into tree at appropriate location.
void BinarySearchTree::Insert(Course iCourse) {
    Node* curNode = root;
    
    // If root is empty assign iCourse to root.
    if (root == NULL) {
        root = new Node(iCourse);
    }
    // Otherwise move on to see where is appropriate to place it
    else {

        // Keeps going till the program reachs the end
        while (curNode != NULL) {

            // If the course's courseId is less than the currentNodes courseId
            if (iCourse.courseId < curNode->course.courseId) {

                // And the currentNodes left child is empty
                if (curNode->left == nullptr) {

                    // Assign the current course as the currentNodes left child
                    curNode->left = new Node(iCourse);

                    // Reset currentNode;
                }

                // Otherwise move currentNode to the currentNode's left child and loop back
                else {
                    curNode = curNode->left;
                }
            }

            // If it's greater instead
            else {

                // And currentNode's right child is empty
                if (curNode->right == nullptr) {

                    // Assign the current course to currentNode's right child
                    curNode->right = new Node(iCourse);

                    // And reset currentNode
                    curNode = NULL;
                }

                // Otherwise move currentNode to currentNode's right child
                else {
                    curNode = curNode->right;
                }
            }
        }

    }
    // Increment the size of the tree
    size++;
}

// Search function to traverse BST and return appropriate course information
Course BinarySearchTree::Search(string courseId) {

    // Initialize local variable for course to be returned as empty object.
    Course iCourse;

    // Set currentNode to start at the root
    Node* curNode = root;

    // Search tree till program comes to an end
    while (curNode != NULL) {

        // If curNode courseId matches return that node
        if (curNode->course.courseId == courseId) {
            return curNode->course;
        }

        // Otherwise if the courseId is smaller than curNode
        // move to the left child of curNode
        else if (courseId < curNode->course.courseId){
            curNode = curNode->left;
        }

        // If it's bigger move curNode to the right child and look again.
        else {
            curNode = curNode->right;
        }
    }
    // Return the course that was found.
    return iCourse;
}

// Sort children so they are in the proper order for the BST
void BinarySearchTree::inOrder(Node* node) {

    // Check that the node isn't NULL
    if (node == NULL) {
        return;
    }

    // Program moves to the left child recursively
    inOrder(node->left);

    // Program prints out the left child
    cout << node->course.courseId << ", " << node->course.courseName << endl;

    // Program moves to the right child recursively
    inOrder(node->right);
}

int BinarySearchTree::Size() {
    return size;
}

// Since Program Input file is a CSV, and there is no CSV text parser given 
// we will need to create a helper function that will read each line 
// and split it based on a delimitter ','. This parsed line will then
// be returned to the function that called it.
vector<string> Split(string lineIn) {
    
    // Store what character we're looking for
    char delimiter = ',';

    // Preprocess lineIn by adding the delimiter to the end of the line 
    // so the final word can be read
    lineIn += delimiter;

    // Vector string that will be returned must be initialized
    vector<string> lineReturn;

    // Place holder string
    string temp = "";

    // Loop through all items in lineIn
    for (int i = 0; i < lineIn.length(); i++) {

        // Read line character by character and see if it matches the delimiter
        if (lineIn[i] == delimiter) {
            
            // Add each word to the Vector lineReturn
            lineReturn.push_back(temp);

            // Reset temp
            temp = "";

            // Increment over delimiter
            i++;
        }

        // Compile all of the characters returned that are not a delimiter for the word
        // as the loop progresses
        temp += lineIn[i];
    }

    // Return the parsed line items to the function that called them
    return lineReturn;
}

// Load courses from CSV path, and sort them into the BST
void loadCourses(string csvPath, BinarySearchTree* courseList) {

    // Initialize input file stream
    ifstream inFS;

    // Initialize string to hold line items
    string line;

    // Initialize vector to hold all items returned from read lines
    vector<string> stringReturn;

    // Open the specified file and begin reading
    inFS.open(csvPath);

    // Check that file does open, and if not return error to system screen
    if (!inFS.is_open()) {
        cout << "File " << csvPath << " not found. Please check input an try again." << endl;

        // Kick out to higher function to prevent hanging.
        return;
    }

    // Continue parsing file until program comes to the end.
    while (!inFS.eof()) {

        // Create new object for each line.
        Course iCourse;

        // Use getline to read each line from File Stream
        getline(inFS, line);

        // Separate the words using a helper function.
        stringReturn = Split(line);

        // Formatting check to ensure line length 
        // if the line isn't over 1 there is a problem
        // or it's empty.
        if (stringReturn.size() < 2) {
            
            // If line is just empty skip it.
            if (line == "") {
                continue;  
            }
            // Otherwise return error message to screen
            else {
                cout << endl;
                cout << "ERROR. Line misread. Skipping line";
            }
            
        }
        // Otherwise if no errors continue parsing
        else {

            // Assign first item from stringReturn as iCourse's courseId 
            iCourse.courseId = stringReturn.at(0);

            // Assign the second item from stringReturn as iCourse's courseName
            iCourse.courseName = stringReturn.at(1);

            // Enter in any prerequisite information, this will start at position 2 onward
            for (int i = 2; i < stringReturn.size(); i++) {
                iCourse.preList.push_back(stringReturn.at(i));
            }
            
            // Add new course into appropriate position in the BST
            courseList->Insert(iCourse);
        }
    }
    // Gracefully close File Stream to conserve system resources
    inFS.close();
}

void showCourse(Course iCourse) {
    // Show course information
    cout << iCourse.courseId << ", " << iCourse.courseName << endl;

    // Check if there are any prerequisites and return them or none if there are none.
    cout << "Prerequisites: ";

    if (iCourse.preList.size() < 2) {
        cout << "none" << endl;
    }
    else {
        for (int i = 0; i < iCourse.preList.size(); i++) {
            cout << iCourse.preList.at(i);

            // Check if there is another prerequisite and add a comma after the item just printed 
            // as long as the next item is not the last one.
            if (iCourse.preList.size() > 1 && i < iCourse.preList.size() - 1) {
                cout << ", ";
            }
        }
        cout << endl;
    }
}

// helper function to make sure user input 
// is in the correct format to prevent errors
void upperCase(string &toConvert) {
    // Loop through string passed in
    for (int i = 0; i < toConvert.length(); i++) {

        // Check if character is alphabetical
        if (isalpha(toConvert[i])) {

            // Recursively use to upper function 
            // to conver alphabetical characters
            toConvert[i] = toupper(toConvert[i]);
        }
    }
}

int main(int argc, char* argv[])
{
    // Initialize variable to store key information.
    string csvPath, iCourseKey;

    // Process command line arguments essential for retrieving relevant information
    switch (argc) {
    
    // If only a csvPath is passed in.
    case 2:
        csvPath = argv[1];
        break;

    // If both csvPath and iCourseKey are passed in
    case 3:
        csvPath = argv[1];
        iCourseKey = argv[2];
        break;
    default:
        csvPath = "CS 300 ABCU_Advising_Program_Input.csv";
    }


    // Initialize BST to hold course information.
    BinarySearchTree* courseList = new BinarySearchTree;

    // Initialize Course object
    Course course;

    // Validation variable check
    bool validInput;

    // Initialize variable to store user menu choice.
    int choice = 0;

    // Display welcome
    cout << "Welcome to the course planner." << endl;

    // Display initial menu
    while (choice != 9) {
        cout << "  1. Load Data Structure." << endl;
        cout << "  2. Print Course List." << endl;
        cout << "  3. Print Course." << endl;
        cout << "  9. Exit" << endl;
        cout << "Enter choice: ";
        
        // Reset the string
        iCourseKey = "";
        
        // Clear choice
        choice = 0;

        // Try/catch statement to look for correct user input
        try {
            cin >> choice;

            if ((choice > 0 && choice < 4) || choice == 9) {
                validInput = true;
            }
            else {
                validInput = false;
                throw 1;
            }

            // Program looks at choice and decides appropriate action
            switch (choice) {

                // Choice = 1, Load Data Structure
            case 1:
                // Call loadCourses function that will read and parse
                // information from CSV file into the BST data structure
                loadCourses(csvPath, courseList);

                // System message to notify user of operation completion.
                cout << endl;
                cout << "Number of courses read into system " << courseList->Size() << endl;
                cout << endl;
                break;
            case 2:
                cout << "Here is a sample schedule: " << endl;
                cout << endl;
                courseList->InOrder();
                break;
            case 3:
                cout << "What course do you want to know about? ";
                cin >> iCourseKey;

                // Make sure proper case for system.
                upperCase(iCourseKey);

                course = courseList->Search(iCourseKey);

                // Check if course is valid and print appropriate output
                if (!course.courseId.empty()) {
                    showCourse(course);
                }
                // else if it's empty/invalid
                else {
                    cout << "Course ID " << iCourseKey << " was not found." << endl;
                }
                break;
            case 9:
                exit;

            // General error catch
            default:
                throw 2;
            }
        }
        // Error thrown prompting user to enter input again.
        catch (int err) {
            cout << choice << " is not a valid option." << endl;
        }

            
    }
    cout << "Thank you for using the course planner!" << endl;
    exit;

}
