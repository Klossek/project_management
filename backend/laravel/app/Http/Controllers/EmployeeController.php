<?php

namespace App\Http\Controllers;

use App\Http\Requests\EmployeeRequest;
use App\Http\Resources\APIPaginateCollection;
use App\Http\Resources\EmployeeResource;
use App\Models\Employee;
use Illuminate\Http\Request;

class EmployeeController extends Controller
{







    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(EmployeeRequest $request)
    {
        $perPage = $request->per_page ? $request->per_page : 10;
        $currentPage = $request->current_page ? $request->current_page : 1;
        /*
        $products = Employee::paginate($perPage, ["*"], "page", $currentPage);
        $response = new APIPaginateCollection($products, EmployeeResource::class);
        */

        //$data =  response()->json($response);
        return view('employees', ['employees' => Employee::all()]);
    }


    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        echo "Hallo";
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
