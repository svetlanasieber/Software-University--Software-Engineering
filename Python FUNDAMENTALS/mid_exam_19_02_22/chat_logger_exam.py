# my_chat_list = []
# command = input().split()
# while command[0] != 'end':
#     if command[0] == 'Chat':
#         message = command[1]
#         my_chat_list.append(message)
#     elif command[0] == 'Delete':
#         message = command[1]
#         if message in my_chat_list:
#             my_chat_list.remove(message)
#     elif command[0] == 'Edit':
#         message = command[1]
#         edited_message = command[2]
#         if message in my_chat_list:
#             index = my_chat_list.index(message)
#             my_chat_list[index] = edited_message
#     elif command[0] == 'Pin':
#         message = command[1]
#         if message in my_chat_list:
#             my_chat_list.remove(message)
#             my_chat_list.append(message)
#     elif command[0] == 'Spam':
#         for message in command[1:]:
#             my_chat_list.append(message)
#     command = input().split()
#
# print('\n'.join(my_chat_list))

def chat_func(input_message, chat_list):
    chat_list.append(input_message)


def delete_func(input_message, chat_list):
    chat_list[:] = [message for message in chat_list if message != input_message]


def edit_func(input_message, new_message, chat_list):
    if input_message in chat_list:
        index = chat_list.index(input_message)
        chat_list[index] = new_message


def pin_func(input_message, chat_list):
    if input_message in chat_list:
        chat_list.remove(input_message)
        chat_list.append(input_message)


def spam_func(input_command, chat_list):
    chat_list.extend(input_command[1:])


my_chat_list = []
command = input().split()
while command[0] != 'end':
    if command[0] == 'Chat':
        message = command[1]
        chat_func(message, my_chat_list)
    elif command[0] == 'Delete':
        message = command[1]
        delete_func(message, my_chat_list)
    elif command[0] == 'Edit':
        message = command[1]
        edited_message = command[2]
        edit_func(message, edited_message, my_chat_list)
    elif command[0] == 'Pin':
        message = command[1]
        pin_func(message, my_chat_list)
    elif command[0] == 'Spam':
        spam_func(command, my_chat_list)

    command = input().split()

print('\n'.join(my_chat_list))