/* eslint-disable react/prop-types */

const Button = ({ name, handleSubmit }) => {
    return (
        <button onClick={(e) => {
            e.preventDefault();
            handleSubmit();
        }} type="submit" className="text-white bg-blue-700
     hover:bg-blue-800 focus:ring-4 focus:outline-none
      focus:ring-blue-300  rounded-lg 
       w-full sm:w-auto px-5 py-2.5 text-center
       dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">

            {name}

        </button>


    );
};

export default Button;