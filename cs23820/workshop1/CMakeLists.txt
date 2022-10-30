cmake_minimum_required(VERSION 3.23)
project(workshop1 C)

set(CMAKE_C_STANDARD 17)
# shows a possible errors
set (CMAKE_CXX_FLAGS "$(CMAKE_CXX_FLAGS) -Wall -Wextra")

add_executable(workshop1 first.c functions.c)
