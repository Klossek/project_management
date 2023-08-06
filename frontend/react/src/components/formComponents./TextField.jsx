/* eslint-disable react/prop-types */
const TextField = ({ lable, value, setValue }) => {
  return (<>
    <label className="flex flex-col justify-start items-start">{lable}
      <input type="text" id="first_name"
        className="bg-gray-50 border
        border-gray-300 text-gray-900 
         rounded-lg focus:ring-blue-500
         focus:border-blue-500 block w-full p-2.5
          dark:bg-gray-700 dark:border-gray-600
           dark:placeholder-gray-400
            dark:text-white
             dark:focus:ring-blue-500
              dark:focus:border-blue-500"
        value={value}
        onChange={(e) => {
          setValue(e.target.value);
        }}
        required />


    </label>
  </>

  );
};

export default TextField;