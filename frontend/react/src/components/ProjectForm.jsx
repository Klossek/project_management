import { useState } from "react";
import TextField from "./formComponents./TextField";
import Button from "./formComponents./Button";

const ProjectForm = ({ onSubmit }) => {
    const [name, setName] = useState("");

    return (
        <form className="m-2 w-80  gap-4 flex flex-col justify-start items-start">

            <TextField
                type="text"
                lable="Enter project name:"
                value={name}
                setValue={setName}
            />
            <Button
                name="Create project"
                handleSubmit={() => {
                    onSubmit({
                        name
                    });
                    setName("");
                }} >save project</Button>
        </form>
    );


};

export default ProjectForm;