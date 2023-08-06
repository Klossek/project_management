/* eslint-disable react/prop-types */

import Employee from './Employee';



const Matrix = ({ projects, employees }) => {


    console.log("employees", employees);
    console.log("projects", projects);
    return <ul>

        {

            employees.map(employee => {
                return <li key={employee.id}>
                    <Employee employee={employee} />
                </li>;
            })
        }
    </ul>;





};

export default Matrix;