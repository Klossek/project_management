/* eslint-disable react/prop-types */

import Assignment from "./Assignment";



const Matrix = ({ table, projects, employees }) => {

    const width = "w-[50px]";

    return <div className={` border-2`}>

        <ul className="flex flex-row justify-between ">
            <li className={`${width}`}></li>
            {
                projects.map((project) => {
                    return <li className={`m-2   ${width}`} key={project.id}>
                        {project.name}
                    </li>;
                })
            }
        </ul >



        <ul className="flex flex-col justify-start items-start  ">
            {
                employees.map((employee, index) => {


                    const row = table[index];
                    if (!row) {
                        return;
                    }
                    return <ul className="flex flex-row justify-between 
                    items-center
                    w-full" key={'employeeId-' + employee.id}>

                        <li className={`  ${width}`} >{employee.name}</li>
                        {row.map((entry) => {
                            return <li key={"entry-" + entry.id}
                                className={`  ${width}`}
                            >
                                <Assignment entry={entry} />
                            </li>;

                        })}
                    </ul>;

                })
            }
        </ul >
    </div >;






};

export default Matrix;