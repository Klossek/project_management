/* eslint-disable react/prop-types */

import { useEmployeesDispatch } from "../EmployeesContext";
import axios from "../api/axios";



const Assignment = ({ entry }) => {


    const dispatch = useEmployeesDispatch();

    const color = entry.assigned ? "bg-green-400" : "bg-slate-200";

    return (
        <div className={`${color} w-6 h-6 m-2 cursor-pointer `} onClick={async () => {
            const employee = entry.employee;
            if (entry.assigned) {
                await axios.post("/employee/" + entry.employeeId + "/removeProject/" + entry.projectId);
                employee.projects =
                    employee.projects.filter((p) => p.id !== entry.project.id);
            } else {
                await axios.post("/employee/" + entry.employeeId + "/assignProject/" + entry.projectId);
                employee.projects.push(entry.project);
            }
            dispatch({
                type: "changed",
                employee
            });
        }}>
        </div>
    );
};

export default Assignment;