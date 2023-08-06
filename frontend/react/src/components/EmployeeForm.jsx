/* eslint-disable react/prop-types */
import { useState } from "react";
import TextField from "./formComponents./TextField";
import Button from "./formComponents./Button";
import { useEmployeesDispatch } from "../EmployeesContext";
import axios from "../api/axios";

const EmployeeForm = () => {
    const [name, setName] = useState("");
    const dispatch = useEmployeesDispatch();
    return (
        <form className="m-2 w-80  gap-4 flex flex-col justify-start items-start">

            <TextField
                type="text"
                lable="Enter employee name:"
                value={name}
                setValue={setName}
            />
            <Button
                name="Create employee"
                handleSubmit={async () => {
                    const employee = {
                        name,
                        email: name + "@gmail.com",
                        dob: new Date().toISOString().slice(0, 10)
                    };
                    const res = await axios.post("/employee", employee);
                    dispatch({
                        type: 'added',
                        employee: res.data,
                    });

                    setName("");
                }} >save employee</Button>
        </form >
    );


};
export default EmployeeForm;